package reference.monoid

interface Monoid<T> {
    fun mempty(): T

    fun mappend(m1: T, m2: T): T
}