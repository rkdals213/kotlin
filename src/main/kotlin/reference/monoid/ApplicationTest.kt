package reference.monoid

fun main() {
    val tree = Node(
        "a", Node(
            "b", Node("c"), Node("d")
        ),
        Node(
            "e", Node(
                "f",
                Node("g")
            )
        )
    )

    println(tree.contains("c"))
    println(tree.contains("z"))
}