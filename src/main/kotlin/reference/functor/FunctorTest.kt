package reference.functor

fun main() {
    println(Just(10).fmap { it + 10 })
    println(Nothing.fmap { a: Int -> a + 10 })
}

interface Functor<out A> {
    fun <B> fmap(f: (A) -> B): Functor<B>
}

sealed class Maybe<out A> : Functor<A> {
    abstract override fun toString(): String

    abstract override fun <B> fmap(f: (A) -> B): Maybe<B>

    companion object
}

data class Just<out A>(val value: A) : Maybe<A>() {
    override fun toString(): String = "Just($value)"

    override fun <B> fmap(f: (A) -> B): Maybe<B> = Just(f(value))
}

object Nothing : Maybe<kotlin.Nothing>() {
    override fun toString(): String = "Nothing"

    override fun <B> fmap(f: (kotlin.Nothing) -> B): Maybe<B> = Nothing
}

fun <A> Maybe.Companion.pure(value: A) = Just(value)

infix fun <A, B> Maybe<(A) -> B>.apply(f: Maybe<A>): Maybe<B> = when (this) {
    is Just -> f.fmap(value)
    is Nothing -> Nothing
}