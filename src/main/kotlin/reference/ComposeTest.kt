package reference

import kotlin.math.abs

fun main() {
    val addThree = { i: Int -> i + 3 }
    val twice = { i: Int -> i * 2 }
    val composeFunc = addThree compose twice
    println(composeFunc(3))

    val absolute = { i: List<Int> -> i.map { abs(it) } }
    val negative = { i: List<Int> -> i.map { -it } }
    val minimum = { i: List<Int> -> i.minOrNull() }

    val input = listOf(3, -1, 5, 2, 4, -8, 14)
    val result = minimum(negative(absolute(input)))
    println(result)

    val composed = minimum compose negative compose absolute
    println(composed(input))

    val composed2 = absolute and negative and minimum
    println(composed(input))

    val powerOfTwo = { x: Int -> power(x.toDouble(), 2).toInt() }
    val gcdPowerOfTwo = { x1: Int, x2: Int -> gcd(powerOfTwo(x1), powerOfTwo(x2)) }

    println(gcdPowerOfTwo(25, 5))

}

infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
    return { gInput: G -> this(g(gInput)) }
}

infix fun <F, G, R> ((F) -> G).and(g: (G) -> R): (F) -> R {
    return { gInput: F -> g(this(gInput)) }
}

tailrec fun gcd(m: Int, n: Int): Int = when (n) {
    0 -> m
    else -> gcd(n, m % n)
}

tailrec fun power(x: Double, n: Int, acc: Double = 1.0): Double = when (n) {
    0 -> acc
    else -> power(x, n - 1, x * acc)
}