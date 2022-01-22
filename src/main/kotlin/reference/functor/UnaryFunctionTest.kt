package reference.functor

import reference.compose

fun main() {
    val f = { a: Int -> a + 1 }
    val g = { b: Int -> b * 2 }
    val fg = UnaryFunction(g).fmap(f)
    println(fg.invoke(5))

    val k = { c: Int -> Just(c) }
    val kg = UnaryFunction(g).fmap(k)
    println(kg.invoke(5))
}

data class UnaryFunction<in T, out R>(val g: (T) -> R) : Functor<R> {
//    override fun <R2> fmap(f: (R) -> R2): UnaryFunction<T, R2> {
//        return UnaryFunction { x: T -> f(g(x)) }
//    }

    override fun <R2> fmap(f: (R) -> R2): UnaryFunction<T, R2> = UnaryFunction { x: T -> (f compose g)(x) }

    fun invoke(input: T): R = g(input)
}