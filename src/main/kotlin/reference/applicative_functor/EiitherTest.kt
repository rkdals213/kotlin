package reference.applicative_functor

import reference.functor.*

fun main() {
    println(Either.pure(10))
    println(Either.pure { x: Int -> x * 2 })

    println(Either.pure { x: Int -> x * 2 } apply Left("error"))
    println(Either.pure { x: Int -> x * 2 } apply Right(10))

    println(
        Either.pure({ x: Int, y: Int -> x * y }.curried())
                apply Left("error")
                apply Right(10)
    )
    println(
        Either.pure({ x: Int, y: Int -> x * y }.curried())
                apply Right(10)
                apply Right(10)
    )
}