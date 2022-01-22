package reference.applicative_functor

fun main() {
    val tree = Node(1, listOf(Node(2), Node(3)))
    println(tree)

    println(tree.fmap { it * 2 })
    println(Tree.pure { x: Int -> x * 2 } apply tree)

    println(
        Tree.pure({ x: Int, y: Int -> x * y }.curried())
                apply Node(1, listOf(Node(2), Node(3)))
                apply Node(4, listOf(Node(5), Node(6)))
    )
}