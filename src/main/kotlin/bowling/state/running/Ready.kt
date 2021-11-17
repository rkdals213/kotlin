package bowling.state.running

import bowling.score.Pin
import bowling.score.Score
import bowling.state.finished.Strike
import bowling.state.State

class Ready : Running() {
    override fun pitch(pin: Pin): State {
        if (pin.isMaxCount()) {
            return Strike()
        }

        return FirstPitch(pin)
    }

    override fun print() = " "

    override fun calculateAdditionalScore(score: Score): Score {
        throw RuntimeException("추가 점수를 계산할 수 없습니다")
    }
}