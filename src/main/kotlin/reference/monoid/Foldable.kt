package reference.monoid

import reference.FunList
import reference.funListOf

interface Foldable<out A> {
    fun <B> foldLeft(acc: B, f: (B, A) -> B): B

    fun <B> foldMap(f: (A) -> B, m: Monoid<B>): B = foldLeft(m.mempty()) { b, a -> m.mappend(b, f(a)) }
}

sealed class BinaryTree<out A> : Foldable<A> {

    override fun <B> foldLeft(acc: B, f: (B, A) -> B): B = when (this) {
        is EmptyTree -> acc
        is Node -> {
            val leftAcc = leftTree.foldLeft(acc, f)
            val rootAcc = f(leftAcc, value)
            rightTree.foldLeft(rootAcc, f)
        }
    }
}

fun <A> BinaryTree<A>.contains(value: A) = foldMap({ it == value }, AnyMonoid())

data class Node<A>(
    val value: A,
    val leftTree: BinaryTree<A> = EmptyTree,
    val rightTree: BinaryTree<A> = EmptyTree
) : BinaryTree<A>()

object EmptyTree : BinaryTree<kotlin.Nothing>()