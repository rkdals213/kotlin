package bowling.domain.frame

import bowling.score.Score
import bowling.state.State

interface Frame {
    fun pitch(count: Int): Frame

    fun nextFrame(): Frame

    fun current(): List<State>

    fun number(): Int

    fun gameFinished(): Boolean

    fun stateFinished(): Boolean

    fun createScore(): Score
}




