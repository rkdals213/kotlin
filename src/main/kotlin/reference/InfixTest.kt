package reference

fun main() {
    val triple = { input: List<Int> -> input.map { it * 3 } }
    val filter = { input: List<Int> -> input.filter { it % 2 == 0 } }
    val toString = { input: List<Int> -> input.map { it.toString() } }
    val reduce = { input: List<String> -> input.reduce { acc: String, s: String -> acc + s } }

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val function = triple next filter next toString next reduce
    val result = function(list)
    println(result)

    val result2 = (triple next filter next toString next reduce)(list)
    println(result2)
}

private infix fun <F, G, R> ((F) -> G).next(g: (G) -> R): (F) -> R {
    return { gInput: F -> g(this(gInput)) }
}