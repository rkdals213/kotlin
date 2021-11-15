package bowling.state.running

import bowling.score.Pin
import bowling.state.State
import bowling.state.finished.Miss
import bowling.state.finished.Spare

class FirstPitch(private val pin: Pin) : Running() {

    override fun pitch(pin: Pin): State {
        if (this.pin.isSpare(pin)) {
            return Spare(this.pin, pin)
        }

        return Miss(this.pin, pin)
    }

    override fun print() = pin.toString()
}