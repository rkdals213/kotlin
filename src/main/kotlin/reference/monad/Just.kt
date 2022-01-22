package reference.monad

data class Just<out A>(val value: A) : Maybe<A>() {
    override fun toString(): String = "Just($value)"
}

object Nothing : Maybe<kotlin.Nothing>() {
    override fun toString(): String = "Nothing"
}

infix fun <A, B> Maybe<(A) -> B>.apply(f: Maybe<A>): Maybe<B> = when (this) {
    is Just -> f.fmap(value)
    else -> Nothing
}