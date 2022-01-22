package reference.monoid

import reference.FunList
import reference.foldRight
import reference.funListOf

fun main() {
    val x = 1
    val y = 2
    val z = 3

    SumMonoid().run {
        println(mappend(mempty(), x) == x)
        println(mappend(x, mempty()) == x)
        println(mappend(mappend(x, y), z) == mappend(x, mappend(y, z)))
    }

    ProductMonoid().run {
        println(mappend(mempty(), x) == x)
        println(mappend(x, mempty()) == x)
        println(mappend(mappend(x, y), z) == mappend(x, mappend(y, z)))
    }

    println(ProductMonoid().mconcat(funListOf(1, 2, 3, 4, 5)))
    println(SumMonoid().mconcat(funListOf(1, 2, 3, 4, 5)))
}

fun <T> Monoid<T>.mconcat(list: FunList<T>): T = list.foldRight(mempty(), ::mappend)