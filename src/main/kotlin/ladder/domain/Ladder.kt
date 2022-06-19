package ladder.domain

class Ladder(
    width: Int,
    val height: Int
) {
    private val _ladderLines: LadderLines = LadderLines(width, height)

    val ladderLines: List<LadderLine>
        get() = _ladderLines.ladderLines

    fun getResult(position: Int): Int {
        var index = position
        for (height in 0 until height) {
            index = _ladderLines.move(index, height)
        }
        return index
    }
}
