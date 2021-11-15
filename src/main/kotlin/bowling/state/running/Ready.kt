package bowling.state.running

import bowling.score.Pin
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
}