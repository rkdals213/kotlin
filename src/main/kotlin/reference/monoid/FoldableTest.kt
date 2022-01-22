package reference.monoid

fun main() {
    val tree = Node(
        1, Node(
            2, Node(3), Node(4)
        ),
        Node(
            5, Node(
                6,
                Node(7)
            )
        )
    )

    println(tree.foldLeft(0) { a, b -> a + b })
    println(tree.foldLeft(1) { a, b -> a * b })

    println(tree.foldMap({ a -> a * 2 }, SumMonoid()))
    println(tree.foldMap({ a -> a + 1 }, ProductMonoid()))
}