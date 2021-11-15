package bowling.domain.frame

import bowling.score.Pin
import bowling.state.finished.Finished

class LastFrame(number: Int) : DefaultFrame(number) {
    override fun pitch(count: Int): Frame {
        state = state.pitch(Pin(count))
        return this
    }

    override fun nextFrame(): Frame {
        throw RuntimeException("더이상 프레임 생성할 수 없습니다")
    }

    override fun current() = state

    override fun isFinished() = state is Finished
}