package reference.applicative_functor

sealed class AMaybe<out A> : Applicative<A> {
    companion object {
        fun <V> pure(value: V): Applicative<V> = AJust(0).pure(value)
    }

    override fun <V> pure(value: V): Applicative<V> = AJust(value)

    abstract override fun <B> apply(f: Applicative<(A) -> B>): AMaybe<B>
}