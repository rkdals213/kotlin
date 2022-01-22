package reference.monad

fun main() {
    val f = { a: Int -> Just(a * 2) }
    val g = { a: Int -> Just(a + 1) }
    val h = { a: Int -> Just(a * 10) }
    val pure = { a: Int -> Just(a) }

    println((pure compose f)(10) == f(10))
    println((f compose pure)(10) == f(10))
    println(((f compose g) compose h)(10) == (f compose (g compose h))(10))
}

infix fun <F, G, R> ((F) -> Monad<R>).compose(g: (G) -> Monad<F>): (G) -> Monad<R> {
    return { gInput: G -> g(gInput) flatMap this }
}