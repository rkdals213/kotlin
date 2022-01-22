package reference.applicative_functor

import reference.functor.*

fun main() {
    identityTest()
    compositionTest()
    homomorphismTest()
    interchangeTest()
    applicativeAndFunctorTest()
}

private fun identityTest() {
    println("identity test start")

    val maybeAf = Just(10)
    val leftMaybe = Maybe.pure(identity()) apply maybeAf
    println(maybeAf.toString() == leftMaybe.toString())

    val treeAf = Node(1, listOf(Node(2), Node(3)))
    val leftTree = Tree.pure(identity()) apply treeAf
    println(treeAf.toString() == leftTree.toString())

    val eitherAf = Right(10)
    val leftEither = Either.pure(identity()) apply eitherAf
    println(eitherAf.toString() == leftEither.toString())
}

private fun compositionTest() {
    println("composition test start")

    val maybeAf1 = Just { x: Int -> x * 2 }
    val maybeAf2 = Just { x: Int -> x + 1 }
    val maybeAf3 = Just(30)

    val leftMaybe = Maybe.pure(compose<Int, Int, Int>().curried()) apply maybeAf1 apply maybeAf2 apply maybeAf3
    val rightMaybe = maybeAf1 apply (maybeAf2 apply maybeAf3)
    println(leftMaybe.toString() == rightMaybe.toString())

    val treeAf1 = Node({ x: Int -> x * 2 })
    val treeAf2 = Node({ x: Int -> x + 1 })
    val treeAf3 = Node(10)

    val leftTree = Tree.pure(compose<Int, Int, Int>().curried()) apply treeAf1 apply treeAf2 apply treeAf3
    val rightTree = treeAf1 apply (treeAf2 apply treeAf3)
    println(leftTree.toString() == rightTree.toString())

    val eitherAf1 = Right { x: Int -> x * 2 }
    val eitherAf2 = Right { x: Int -> x + 1 }
    val eitherAf3 = Right(10)

    val leftEither = Either.pure(compose<Int, Int, Int>().curried()) apply eitherAf1 apply eitherAf2 apply eitherAf3
    val rightEither = eitherAf1 apply (eitherAf2 apply eitherAf3)
    println(leftEither.toString() == rightEither.toString())
}

private fun homomorphismTest() {
    println("homomorphism test start")

    val function = { x: Int -> x * 2 }
    val x = 10

    val leftMaybe = Maybe.pure(function) apply Maybe.pure(x)
    val rightMaybe = Maybe.pure(function(x))
    println(leftMaybe.toString() == rightMaybe.toString())

    val leftTree = Tree.pure(function) apply Tree.pure(x)
    val rightTree = Tree.pure(function(x))
    println(leftTree.toString() == rightTree.toString())

    val leftEither = Either.pure(function) apply Either.pure(x)
    val rightEither = Either.pure(function(x))
    println(leftEither.toString() == rightEither.toString())
}

private fun interchangeTest() {
    println("interchange test start")

    val x = 10
    val maybeAf = Just { a: Int -> a * 2 }
    val leftMaybe = maybeAf apply Maybe.pure(x)
    val rightMaybe = Maybe.pure(of<Int, Int>(x)) apply maybeAf
    println(leftMaybe.toString() == rightMaybe.toString())

    val treeAf = Node({ a: Int -> a * 2 })
    val leftTreeAf = treeAf apply Tree.pure(x)
    val rightTreeAf = Tree.pure(of<Int, Int>(x)) apply treeAf
    println(leftTreeAf.toString() == rightTreeAf.toString())

    val eitherAf = Right { a: Int -> a * 2 }
    val leftEitherAf = eitherAf apply Either.pure(x)
    val rightEitherAf = Either.pure(of<Int, Int>(x)) apply eitherAf
    println(leftEitherAf.toString() == rightEitherAf.toString())
}

private fun applicativeAndFunctorTest() {
    println("applicative and functor test start")

    val function = { x: Int -> x * 2 }

    val maybeAf = Just(10)
    val leftMaybeAf = Maybe.pure(function) apply maybeAf
    val rightMaybeAf = maybeAf.fmap(function)
    println(leftMaybeAf.toString() == rightMaybeAf.toString())

    val treeAf = Node(1, listOf(Node(2), Node(2)))
    val leftTree = Tree.pure(function) apply treeAf
    val rightTree = treeAf.fmap(function)
    println(leftTree.toString() == rightTree.toString())

    val eitherAf = Right(10)
    val leftEitherAf = Either.pure(function) apply eitherAf
    val rightEitherAf = eitherAf.fmap(function)
    println(leftEitherAf.toString() == rightEitherAf.toString())
}

fun identity() = { x: Int -> x }

fun <P1, P2, P3> compose() = { f: (P2) -> P3, g: (P1) -> P2, v: P1 -> f(g(v)) }

fun <T, R> of(value: T) = { f: (T) -> R -> f(value) }
