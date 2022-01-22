package reference.functor

fun main() {
    val f = { a: Int -> a + 1 }
    val g = { b: Int -> b * 2 }

    val nothingLeft = Nothing.fmap(f compose g)
//    val nothingRight = Nothing.fmap(f) compose Nothing.fmap(g)    // 컴파일 오류
    val nothingRight = Nothing.fmap(g).fmap(f)
    println(nothingLeft == nothingRight)

    val justLeft = Just(5).fmap(f compose g)
//    val justRight = Just(5).fmap(f) compose Just(0).fmap(g)   // 컴파일 오류
    val justRight = Just(5).fmap(g).fmap(f)
    println(justLeft == justRight)

    val tree = Node(1, Node(2, EmptyTree, EmptyTree), Node(3, EmptyTree, EmptyTree))

    println(EmptyTree.fmap(f compose g) == EmptyTree.fmap(g).fmap(f))
    println(tree.fmap(f compose g) == tree.fmap(g).fmap(f))

    println(Left("error").fmap(f compose g) == Left("error").fmap(g).fmap(f))
    println(Right(5).fmap(f compose g) == Right(5).fmap(g).fmap(f))
}


infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
    return { gInput: G -> this(g(gInput)) }
}