package bowling.state.finished

import bowling.score.Pin

class Spare(private val first: Pin, private val second: Pin) : Finished() {

    companion object {
        private const val DESC = "/"
    }

    override fun print() = "$first|$DESC"
}