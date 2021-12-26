package ladder.domain

class LadderLine(val points: Points) {
    fun move(index: Int) = points.move(index)
}