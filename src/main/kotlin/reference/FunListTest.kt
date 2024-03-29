package reference

fun main() {
    val list = FunList.Cons(1, FunList.Cons(2, FunList.NIL))
    val addHead = list.addHead(3)
    println(addHead)

    val appendTail = list.appendTail(3)
    println(appendTail)

    val reverse = list.reverse()
    println(reverse)

    val tail = list.getTail()
    println(tail)

    val filter = list.filter { x: Int -> x < 2 }
    println(filter)

    val add3 = list.map { it + 3 }
    println(add3)
    val product3 = list.map { it * 3 }
    println(product3)

    val intList = funListOf(1, 2, 3, 4, 5)
    println(sumByFoldLeft(intList))
}

sealed class FunList<out T> {
    object NIL : FunList<Nothing>()
    data class Cons<out T>(
        val head: T,
        val tail: FunList<T>
    ) : FunList<T>()
}

fun <T> funListOf(vararg elements: T): FunList<T> = elements.toFunList()

private fun <T> Array<out T>.toFunList(): FunList<T> = when {
    this.isEmpty() -> FunList.NIL
    else -> FunList.Cons(this[0], this.copyOfRange(1, this.size).toFunList())
}

fun <T> FunList<T>.addHead(head: T): FunList<T> = FunList.Cons(head, this)

fun <T> FunList<T>.appendTail(value: T, acc: FunList<T> = FunList.NIL): FunList<T> = when (this) {
    FunList.NIL -> FunList.Cons(value, acc).reverse()
    is FunList.Cons -> FunList.Cons(head, tail.appendTail(value))
}

tailrec fun <T> FunList<T>.reverse(acc: FunList<T> = FunList.NIL): FunList<T> = when (this) {
    FunList.NIL -> acc
    is FunList.Cons -> tail.reverse(acc.addHead(head))
}

fun <T> FunList<T>.getTail(): FunList<T> = when (this) {
    FunList.NIL -> throw NoSuchElementException()
    is FunList.Cons -> tail
}

tailrec fun <T> FunList<T>.filter(acc: FunList<T> = FunList.NIL, p: (T) -> Boolean): FunList<T> = when (this) {
    FunList.NIL -> acc.reverse()
    is FunList.Cons -> if (p(head)) {
        tail.filter(acc.addHead(head), p)
    } else {
        tail.filter(acc, p)
    }
}

fun add3(list: FunList<Int>): FunList<Int> = when (list) {
    FunList.NIL -> FunList.NIL
    is FunList.Cons -> FunList.Cons(list.head + 3, add3(list.tail))
}

fun product3(list: FunList<Int>): FunList<Int> = when (list) {
    FunList.NIL -> FunList.NIL
    is FunList.Cons -> FunList.Cons(list.head * 3, product3(list.tail))
}

tailrec fun <T, R> FunList<T>.map(acc: FunList<R> = FunList.NIL, f: (T) -> R): FunList<R> = when (this) {
    FunList.NIL -> acc.reverse()
    is FunList.Cons -> tail.map(acc.addHead(f(head)), f)
}

tailrec fun <T, R> FunList<T>.foldLeft(acc: R, f: (R, T) -> R): R = when (this) {
    FunList.NIL -> acc
    is FunList.Cons -> tail.foldLeft(f(acc, head), f)
}

fun <T, R> FunList<T>.foldRight(acc: R, f: (T, R) -> R): R = when (this) {
    FunList.NIL -> acc
    is FunList.Cons -> f(head, tail.foldRight(acc, f))
}

fun sumByFoldLeft(list: FunList<Int>): Int = list.foldLeft(0) { acc, x -> acc + x }

fun <T> printFunList(list: FunList<T>) = list.toStringByFoldLeft()

fun <T> FunList<T>.toStringByFoldLeft() = println("[${foldLeft("") { acc, x -> "$acc, $x" }.drop(2)}]")