package reference.monad

fun main() {
    val list1 = funListOf(1, 2, 3)
    val list2 = funListOf(5, 10, 15, 20)

    println(list1.mempty())
    println(list1 mappend list2)

    println(FunList.pure(10))

    val list3 = funListOf<(Int) -> Int>({ x -> x * 2 }, { x -> x + 1 }, { x -> x - 10 })

    println(list3 apply list1)
    println(list3 apply list2)
    println(list1 apply2 list3)
    println(list2 apply2 list3)

    println(Nil flatmap { x -> funListOf(x) })
    println(list1 flatmap { x -> funListOf(x, -x) })

    println(funListOf(list1, list2).flatten())

    println(Nil flatmap2 { x -> funListOf(x) })
    println(list1 flatmap2 { x -> funListOf(x, -x) })
}