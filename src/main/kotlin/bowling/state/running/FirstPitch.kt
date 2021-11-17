package bowling.state.running

import bowling.score.Pin
import bowling.score.Score
import bowling.state.State
import bowling.state.finished.Miss
import bowling.state.finished.Spare

class FirstPitch(private val pin: Pin) : Running() {
    companion object {
        private const val MAX_COUNT = 10
    }

    override fun pitch(pin: Pin): State {
        require(totalShouldBeUnderTheMax(pin)) {
            "한 프레임에 쓰러뜨릴 수 있는 핀의 갯수는 10개 이하입니다"
        }

        if (this.pin.isSpare(pin)) {
            return Spare(this.pin, pin)
        }

        return Miss(this.pin, pin)
    }

    private fun totalShouldBeUnderTheMax(pin: Pin) = this.pin.plus(pin)
        .count() <= MAX_COUNT

    override fun print() = pin.toString()

    override fun calculateAdditionalScore(score: Score): Score {
        val temp = score.addPin(pin)
        if (temp.canCalculateScore()) {
            return temp
        }

        throw RuntimeException("추가 점수를 계산할 수 없습니다")
    }
}