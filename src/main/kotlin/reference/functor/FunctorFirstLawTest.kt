package reference.functor

fun main() {
    println(Nothing.fmap { identify(it) } == identify(Nothing))
    println(Just(5).fmap { identify(it) } == identify(Just(5)))

    val tree = Node(1, Node(2, EmptyTree, EmptyTree), Node(3, EmptyTree, EmptyTree))

    println(EmptyTree.fmap { identify(it) } == identify(EmptyTree))
    println(tree.fmap { identify(it) } == identify(tree))

    println(Left("error").fmap { identify(it) } == identify(Left("error")))
    println(Right(5).fmap { identify(it) } == identify(Right(5)))
}

fun <T> identify(x: T): T = x