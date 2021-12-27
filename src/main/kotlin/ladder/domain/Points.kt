package ladder.domain

import java.util.*

class Points(val width: Int) {
    val points: List<Point>

    init {
        val tempList: MutableList<Point> = mutableListOf()
        for (i in 0 until width) {
            val now = makeRandomPoint(tempList, i)
            tempList.add(now)
        }

        points = tempList.toList()
    }

    private fun makeRandomPoint(
        tempList: MutableList<Point>,
        index: Int
    ): Point {
        if (index == 0) {
            return Point.getByIndex(RANDOM.nextInt(2) + 1)
        }

        if (tempList[index - 1] == Point.RIGHT) {
            return Point.LEFT
        }

        if (index == width - 1) {
            return Point.DOWN
        }

        return Point.getByIndex(RANDOM.nextInt(2) + 1)
    }

    fun move(index: Int): Int = points[index].apply(index)

    companion object {
        private val RANDOM = Random()
    }
}
