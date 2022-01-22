package reference.applicative_functor

import reference.FunList
import reference.foldRight
import reference.funListOf
import reference.functor.*
import reference.functor.Nothing
import reference.printFunList

fun main() {
    when (val result = sequenceA(funListOf(Just(10), Just(20)))) {
        is Nothing -> Nothing
        is Just -> printFunList(result.value)
    }

    when (val result = sequenceAByFoldRight(funListOf(Just(10), Just(20)))) {
        is Nothing -> Nothing
        is Just -> printFunList(result.value)
    }
}

fun <A, B, R> liftA2(binaryFunction: (A, B) -> R) = { f1: Maybe<A>, f2: Maybe<B> -> Maybe.pure(binaryFunction.curried()) apply f1 apply f2 }

fun <T> cons() = { x: T, xs: FunList<T> -> FunList.Cons(x, xs) }

fun <T> sequenceA(maybeList: FunList<Maybe<T>>): Maybe<FunList<T>> = when (maybeList) {
    is FunList.NIL -> Just(funListOf())
    is FunList.Cons -> Maybe.pure(cons<T>().curried()) apply maybeList.head apply sequenceA(maybeList.tail)
}

fun <T> sequenceAByFoldRight(maybeList: FunList<Maybe<T>>): Maybe<FunList<T>> = maybeList.foldRight(Maybe.pure(funListOf()), liftA2(cons()))