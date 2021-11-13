package racing.view

import racing.domain.Cars
import racing.strategy.DefaultMoveStrategy

class OutputView {
    companion object {
        fun printResult(tryCount: Int, cars: Cars) {
            println("실행 결과")
            for (i in 1..tryCount) {
                cars.move(DefaultMoveStrategy())
                printCurrent(cars)
            }
            printWinner(cars)
        }

        private fun printCurrent(cars: Cars) {
            val participants = cars.participants()
            participants.forEach {
                println("${it.participant()} : ${distanceToLine(it.position())}")
            }
            println()
        }

        private fun printWinner(cars: Cars) {
            val max = cars.participants()
                    .maxOf { it.position() }

            val winners = cars.participants()
                    .filter { it.position() == max }
                    .map { it.participant() }
                    .joinToString { it.toString() }

            println("${winners}가 최종 우승했습니다")
        }

        private fun distanceToLine(distance: Int) = "-".repeat(distance)
    }
}