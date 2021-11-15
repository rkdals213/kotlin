package bowling.domain.frame

import bowling.state.State

interface Frame {
    fun pitch(count: Int): Frame

    fun nextFrame(): Frame

    fun current(): State

    fun number(): Int

    fun isFinished(): Boolean
}




