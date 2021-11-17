package bowling.domain.frame

import bowling.score.Pin
import bowling.score.Score
import bowling.state.State
import bowling.state.running.Ready


class LastFrame(number: Int) : DefaultFrame(number) {
    private val bonusStates: MutableList<State> = mutableListOf()

    override fun pitch(count: Int): Frame {
        checkIsFinished();

        if (!state.isFinished()) {
            state = state.pitch(Pin(count))
            return this;
        }

        if (bonusStates.isEmpty() || bonusStates.last().isFinished()) {
            val nextState = Ready()
            bonusStates.add(nextState.pitch(Pin(count)))
            return this
        }

        val state = bonusStates.last()
        bonusStates.removeLast()
        bonusStates.add(state.pitch(Pin(count)))
        return this
    }

    private fun checkIsFinished() {
        if (gameFinished()) {
            throw RuntimeException()
        }
    }

    fun score(): Score {
        var score = createScore()
        for (bonusState in bonusStates) {
            score = bonusState.calculateAdditionalScore(score)
        }
        return score
    }

    override fun nextFrame(): Frame {
        throw RuntimeException("더이상 프레임 생성할 수 없습니다")
    }

    override fun current(): List<State> = listOf(state).plus(bonusStates)

    override fun gameFinished() = try {
        score().canCalculateScore()
    } catch (e: Exception) {
        false
    }

    override fun stateFinished() = state.isFinished()
}