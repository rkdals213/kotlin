package reference.applicative_functor

data class AJust<out A>(val value: A) : AMaybe<A>() {
    override fun toString(): String = "AJust($value)"

    override fun <B> apply(f: Applicative<(A) -> B>): AMaybe<B> = when (f) {
        is AJust -> fmap(f.value)
        else -> ANothing
    }

    override fun <B> fmap(f: (A) -> B): AMaybe<B> = AJust(f(value))
}