package ladder.domain

class Ladder(
    width: Int,
    val height: Int
) {
    val ladderLines: LadderLines = LadderLines(width, height)

    fun getResult(position: Int): Int {
        var index = position
        for (height in 0 until height) {
            index = ladderLines.move(index, height)
        }
        return index
    }
}
