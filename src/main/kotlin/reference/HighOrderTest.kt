package reference

fun main() {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val minus: (Int, Int) -> Int = { x, y -> x - y }
    val product: (Int, Int) -> Int = { x, y -> x * y }
    val twiceSum: (Int, Int) -> Int = { x, y -> (x + y) * 2 }

    println(higherOrder(sum, 1, 5))
    println(higherOrder(minus, 1, 5))
    println(higherOrder(product, 1, 5))
    println(higherOrder(twiceSum, 1, 5))
}

fun higherOrder(func: (Int, Int) -> (Int), x: Int, y: Int): Int = func(x, y)
