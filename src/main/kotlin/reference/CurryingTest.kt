package reference

fun main() {
    println(multiThree(1, 2, 3))

    val partial1 = multiThree(1)
    val partial2 = partial1(2)
    val partial3 = partial2(3)

    println(partial3)

    println(multiThree(1)(2)(3))
}

fun multiThree(a: Int, b: Int, c: Int) = a * b * c

fun multiThree(a: Int) = { b: Int -> { c: Int -> a * b * c } }

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R = { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }

fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncurried(): (P1, P2, P3) -> R = { p1: P1, p2: P2, p3: P3 -> this(p1)(p2)(p3) }