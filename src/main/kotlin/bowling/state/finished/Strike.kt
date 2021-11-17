package bowling.state.finished

import bowling.score.Pin
import bowling.score.Score

class Strike : Finished() {
    companion object {
        private const val DESC = "X"
    }

    override fun print() = DESC

    override fun createScore() = Score.strike()

    override fun calculateAdditionalScore(score: Score) = score.addPin(Pin(10));
}