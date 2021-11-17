package bowling.domain.frame

import bowling.state.State
import bowling.state.running.Ready


abstract class DefaultFrame(private val number: Int) : Frame {
    protected var state: State = Ready()

    companion object {
        const val END_OF_FRAMES = 10
    }

    override fun number() = number

    override fun createScore() = state.createScore()

}