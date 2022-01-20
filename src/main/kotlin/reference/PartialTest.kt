package reference

fun main() {
    val condition: (Int) -> Boolean = { it in 1..3 }
    val body: (Int) -> String = {
        when (it) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            else -> throw IllegalArgumentException()
        }
    }

    val oneTwoThree = PartialFunction(condition, body)
    if (oneTwoThree.isDefinedAt(3)) {
        println(oneTwoThree)
    } else {
        println("isDefinedAt(x) return false")
    }

    val func = { a: String, b: String -> a + b }

    val partiallyAppliedFunc1 = func.partial1("hello")
    val result1 = partiallyAppliedFunc1("world")

    println(result1)

    val partiallyAppliedFunc2 = func.partial2("hello")
    val result2 = partiallyAppliedFunc2("world")

    println(result2)
}

class PartialFunction<in P, out R>(
    private val condition: (P) -> Boolean,
    private val f: (P) -> R
) : (P) -> R {
    override fun invoke(p: P): R = when {
        condition(p) -> f(p)
        else -> throw IllegalArgumentException()
    }

    fun isDefinedAt(p: P): Boolean = condition(p)
}

fun <P1, P2, R> ((P1, P2) -> R).partial1(p1: P1): (P2) -> R {
    return { p2 -> this(p1, p2) }
}

fun <P1, P2, R> ((P1, P2) -> R).partial2(p2: P2): (P1) -> R {
    return { p1 -> this(p1, p2) }
}