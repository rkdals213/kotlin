package racing.strategy

interface MoveStrategy {
    fun move(key: Int): Int
}

class DefaultMoveStrategy : MoveStrategy {
    override fun move(key: Int) = if (key > 6) 1 else 0
}