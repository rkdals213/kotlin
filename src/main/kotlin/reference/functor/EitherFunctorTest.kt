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

data class Left<out L>(val value: L) : Either<L, Nothing>() {
    override fun <B> fmap(f: (Nothing) -> B): Either<L, B> = this
}

data class Right<out R>(val value: R) : Either<Nothing, R>() {
    override fun <B> fmap(f: (R) -> B): Either<Nothing, B> = Right(f(value))
}

fun divideTenByN(n: Int): Either<String, Int> = try {
    Right(10 / n)
} catch (e: ArithmeticException) {
    Left("divided by zero")
}