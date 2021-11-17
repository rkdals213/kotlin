package bowling.domain.frame

import bowling.score.Pin

class NormalFrame(private val number: Int) : DefaultFrame(number) {
    override fun pitch(count: Int): Frame {
        state = state.pitch(Pin(count))

        if (state.isFinished()) {
            return nextFrame()
        }

        return this
    }

    override fun nextFrame(): Frame {
        if (number + 1 == END_OF_FRAMES) {
            return LastFrame(number + 1)
        }

        return NormalFrame(number + 1)
    }

    override fun current() = listOf(state)

    override fun gameFinished() = false

    override fun stateFinished() = state.isFinished()
}
