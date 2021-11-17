package bowling.state

import bowling.score.Pin
import bowling.score.Score

interface State {
    fun pitch(pin: Pin): State

    fun isFinished(): Boolean

    fun print(): String

    fun createScore(): Score

    fun calculateAdditionalScore(score: Score): Score
}