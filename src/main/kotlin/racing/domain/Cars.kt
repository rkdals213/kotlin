package racing.domain

import racing.strategy.MoveStrategy
import java.util.*

class Cars(names: List<Name>) {
    private val cars: List<Car>
    private val random = Random()

    init {
        cars = names.map { Car(it, Position(0)) }
    }

    fun move(moveStrategy: MoveStrategy) = cars.forEach { it.move(moveStrategy.move(randomValue())) }

    fun participants() = cars

    private fun randomValue() = random.nextInt(10) + 1
}