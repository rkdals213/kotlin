package bowling.state.finished

import bowling.score.Pin
import bowling.score.Score
import bowling.state.State

class Miss(private val first: Pin, private val second: Pin) : Finished() {

    override fun print() = "$first|$second"

    override fun createScore() = Score.miss(first.plus(second).count())

    override fun calculateAdditionalScore(score: Score): Score {
        val temp = score.addPin(first);
        if (temp.canCalculateScore()) {
            return temp;
        }
        return temp.addPin(second);
    }
}