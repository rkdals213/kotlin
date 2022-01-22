package reference.functor

fun main() {
    println(divideTenByN(5))
    println(divideTenByN(0))
    println(divideTenByN(5).fmap { it * 2 })
    println(divideTenByN(0).fmap { it * 2 })
}

sealed class Either<out L, out R> : Functor<R> {
    abstract override fun <B> fmap(f: (R) -> B): Functor<B>
}

data class Left<out L>(val value: L) : Either<L, kotlin.Nothing>() {
    override fun <R2> fmap(f: (kotlin.Nothing) -> R2): Either<L, R2> = this
}

data class Right<out R>(val value: R) : Either<kotlin.Nothing, R>() {
    override fun <R2> fmap(f: (R) -> R2): Either<kotlin.Nothing, R2> = Right(f(value))
}

fun divideTenByN(n: Int): Either<String, Int> = try {
    Right(10 / n)
} catch (e: ArithmeticException) {
    Left("divided by zero")
}