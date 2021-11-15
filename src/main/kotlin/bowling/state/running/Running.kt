package bowling.state.running

import bowling.state.State

abstract class Running : State {
    override fun isFinished() = false
}