package bowling.state.finished

import bowling.score.Pin
import bowling.score.Score

class Spare(private val first: Pin, private val second: Pin) : Finished() {

    companion object {
        private const val DESC = "/"
    }

    override fun print() = "$first|$DESC"

    override fun createScore() = Score.spare()

    override fun calculateAdditionalScore(score: Score): Score {
        val temp = score.addPin(first);
        if (temp.canCalculateScore()) {
            return temp;
        }
        return temp.addPin(second);
    }
}