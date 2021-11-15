package bowling.state.finished

import bowling.score.Pin
import bowling.state.State

abstract class Finished : State {
    override fun pitch(pin: Pin): State {
        throw RuntimeException("더이상 던질 수 없습니다")
    }

    override fun isFinished() = true
}