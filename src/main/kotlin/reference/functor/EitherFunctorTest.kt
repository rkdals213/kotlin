package reference.functor

fun main() {
    println(divideTenByN(5))
    println(divideTenByN(0))
    println(divideTenByN(5).fmap { it * 2 })
    println(divideTenByN(0).fmap { it * 2 })
}

sealed class Either<out L, out R> : Functor<R> {
    abstract override fun <B> fmap(f: (R) -> B): Either<L, B>

    companion object
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

fun <A> Either.Companion.pure(value: A) = Right(value)

infix fun <L, A, B> Either<L, (A) -> B>.apply(f: Either<L, A>): Either<L, B> = when (this) {
    is Left -> this
    is Right -> f.fmap(value)
}