package bowling.state

import bowling.score.Pin

interface State {
    fun pitch(pin: Pin): State

    fun isFinished(): Boolean

    fun print(): String
}