package ladder.domain

class LadderLines(width: Int, height: Int) {
    val ladderLines: List<LadderLine> = List(height) {
        LadderLine(Points(width))
    }

    fun move(index: Int, height: Int): Int = ladderLines[height].move(index)
}