package reference.monoid

import reference.functor.Just

fun main() {
    val x = Just(1)
    val y = Just(2)
    val z = Just(3)

    MaybeMonoid.monoid(ProductMonoid()).run {
        println(mappend(mempty(), x) == x)
        println(mappend(x, mempty()) == x)
        println(mappend(mappend(x, y), z) == mappend(x, mappend(y, z)))
    }

    MaybeMonoid.monoid(SumMonoid()).run {
        println(mappend(mempty(), x) == x)
        println(mappend(x, mempty()) == x)
        println(mappend(mappend(x, y), z) == mappend(x, mappend(y, z)))
    }
}