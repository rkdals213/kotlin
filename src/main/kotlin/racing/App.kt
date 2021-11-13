package racing

import racing.domain.Cars
import racing.utils.Names
import racing.view.InputView
import racing.view.OutputView

fun main() {
    val names = InputView.getNames()
    val tryCount = InputView.getTryCount()

    val participants = Names(names).listOfName()
    val cars = Cars(participants)

    OutputView.printResult(tryCount, cars)
}