package reference.monad

import reference.applicative_functor.curried

fun main() {
    println(Just(10).fmap { it + 10 })
    println(Nothing.fmap { x: Int -> x + 10 })

    println(Maybe.pure(10))
    println(Maybe.pure { x: Int -> x + 10 })

    println(Maybe.pure { x: Int -> x * 2 } apply Just(10))
    println(Maybe.pure { x: Int -> x * 2 } apply Nothing)
    println(
        Maybe.pure({ x: Int, y: Int -> x * y }.curried())
                apply Just(10)
                apply Just(20)
    )

    println(
        Maybe.pure({ x: Int, y: Int, z: Int -> x * y * z }.curried())
                apply Just(10)
                apply Just(20)
                apply Just(30)
    )

    println(Just(10).leadTo(Nothing))
    println(Nothing.leadTo(Just(10)))
    println(Just(10).leadTo(Just(20)))

    println(Just(10).flatMap { x -> Maybe.pure(x * 2) })
    println(Nothing.flatMap { x: Int -> Maybe.pure(x * 2) })
    println(Just(Just(10)).flatMap { m -> m.fmap { x -> x * 2 } })
}