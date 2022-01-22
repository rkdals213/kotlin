package reference.applicative_functor

import reference.functor.Functor

interface Applicative<out A> : Functor<A> {
    fun <V> pure(value: V): Applicative<V>

    infix fun <B> apply(f: Applicative<(A) -> (B)>): Applicative<B>
}