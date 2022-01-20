package reference

import kotlin.math.cos

fun main() {
    val findFixPoint = findFixPoint()
    println(findFixPoint)
}

tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == cos(x)) x else findFixPoint(cos(x))
