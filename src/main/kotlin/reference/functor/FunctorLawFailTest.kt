package reference.functor

fun main() {
    println(
        JustCounter(10, 3)
            .fmap { it + 10 }
            .fmap { it * 2 }
    )
    println(NothingCounter.fmap { x: Int -> x + 10 })

    println(NothingCounter.fmap { identify(it) } == identify(NothingCounter))
    println(JustCounter(5, 0).fmap { identify(it) } == identify(JustCounter(5, 0)))

    val f = { a: Int -> a + 1 }
    val g = { b: Int -> b * 2 }

    val nothingLeft = NothingCounter.fmap(f compose g)
    val notingRight = NothingCounter.fmap(g).fmap(f)
    println(nothingLeft == notingRight)

    val justLeft = JustCounter(5, 0).fmap(f compose g)
    val justRight = JustCounter(5, 0).fmap(g).fmap(f)
    println(justLeft == justRight)
}

sealed class MaybeCounter<out A> : Functor<A> {
    abstract override fun toString(): String

    abstract override fun <B> fmap(f: (A) -> B): MaybeCounter<B>
}

data class JustCounter<out A>(val value: A, val count: Int) : MaybeCounter<A>() {
    override fun toString(): String = "JustCounter($value, $count)"

    override fun <B> fmap(f: (A) -> B): MaybeCounter<B> = JustCounter(f(value), count + 1)
}

object NothingCounter : MaybeCounter<kotlin.Nothing>() {
    override fun toString(): String = "NothingCounter"

    override fun <B> fmap(f: (kotlin.Nothing) -> B): MaybeCounter<B> = NothingCounter
}