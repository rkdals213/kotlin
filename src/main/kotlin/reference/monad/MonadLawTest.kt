package reference.monad

fun main() {
    val x = 10
    val f = { a: Int -> Just(a * 2) }
    val g = { a: Int -> Just(a + 1) }
    val pure = { a: Int -> Just(a) }
    val m = Just(10)

    println(pure(x) flatMap f == f(x)) // left identity law
    println(m flatMap pure == m) // right identity law
    println((m flatMap f) flatMap g == m flatMap { a -> f(a) flatMap g }) // associativity law
}