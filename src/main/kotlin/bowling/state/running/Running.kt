package bowling.state.running

import bowling.score.Score
import bowling.state.State


abstract class Running : State {
    override fun isFinished() = false

    override fun createScore(): Score {
        throw RuntimeException("점수를 만들 수 없습니다")
    }
}