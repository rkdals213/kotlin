package reference.functor

fun main() {
    val product: (Int, Int) -> Int = { x: Int, y: Int -> x * y }
    val curriedProduct = product.curried()
    val maybeProduct = Just(10).fmap(curriedProduct)
    println(maybeProduct.fmap { it(5) })
}

fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = { p1: P1 -> { p2: P2 -> this(p1, p2) } }
