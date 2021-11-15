package bowling.state.finished

import bowling.score.Pin
import bowling.state.State

class Miss(private val first: Pin, private val second: Pin) : Finished() {

    override fun print() = "$first|$second"
}