package reference.applicative_functor

import reference.functor.*
import reference.functor.Nothing

fun main() {
    println(AJust(10).fmap { it + 10 })
    println(ANothing.fmap { x: Int -> x + 10 })

    println(AMaybe.pure(10))

    println(AJust(10) apply AJust { x: Int -> x * 2 })
    println(ANothing apply AJust { x: Int -> x * 2 })

    println(
        AMaybe.pure(10)
                apply AJust { x: Int -> x * 2 }
                apply AJust { x: Int -> x + 10 }
    )

    /*println(
        AMaybe.pure { x: Int -> x * 2 }
                apply AJust(5)
                apply AJust(10)
    )*/ // 컴파일 오류

    println(Just(10).fmap { it + 10 })
    println(Nothing.fmap { it: Int -> it + 10 })

    println(Maybe.pure(10))
    println(Maybe.pure { x: Int -> x * 2 })

    println(Maybe.pure { x: Int -> x * 2 } apply Just(10))
    println(Maybe.pure { x: Int -> x * 2 } apply Nothing)

    println(
        Maybe.pure({ x: Int, y: Int -> x * y }.curried())
                apply Just(10)
                apply Just(20)
    )
    println(
        Maybe.pure({ x: Int, y: Int, z: Int -> x * y + z }.curried())
                apply Just(10)
                apply Just(20)
                apply Just(30)
    )
}

fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = { p1: P1 -> { p2: P2 -> this(p1, p2) } }

fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R = { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }
