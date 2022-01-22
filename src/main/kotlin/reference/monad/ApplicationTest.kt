package reference.monad

fun main() {
    val list = funListOf(1, 2)
    println(list)

    val flatmap = list.flatmap { x -> funListOf(x to 'a', x to 'c') }
    println(flatmap)

    val fmap = flatmap.fmap { x -> x.first to x.second.uppercaseChar() }
    println(fmap)

    val apply2 = fmap.apply2(funListOf({ x -> x.second }, { x -> x.second + x.first }))
    println(apply2)

    val contains = apply2.foldLeft(Nil as FunList<Char>) { acc, x -> if (acc.contains(x)) acc else Cons(x, acc) }
    println(contains) // 결과적으론 distinct

    val distinct = apply2.distinct()
    println(distinct)

    val reverse = distinct.reverse()
    println(reverse)
}