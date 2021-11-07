package lotto.view.input

import lotto.lottoPlace.LastWeekLotto
import lotto.domain.Number
import java.util.*

class InputView {
    companion object {
        private val scanner = Scanner(System.`in`)

        fun getCost(): Int {
            println("구입금액을 입력해 주세요")
            return scanner.nextInt()
        }

        fun getCountOfManualBuy(): Int {
            println("수동으로 구매할 로또 수를 입력해 주세요")
            return scanner.nextInt()
        }

        fun getManualLottoNumbers(count: Int): List<List<Int>> {
            if (count == 0) {
                return mutableListOf()
            }

            println("수동으로 구매할 번호를 입력해 주세요")
            val inputs: MutableList<List<Int>> = mutableListOf()

            for (i in 1..count) {
                val input = scanner.next()
                val numbers = stringToIntList(input)
                inputs.add(numbers)
            }

            return inputs.toList()
        }

        private fun stringToIntList(text: String): List<Int> {
            return text.split(",")
                .toList()
                .map { s -> s.toInt() }
        }

        fun getLastWeekLottoNumber(): LastWeekLotto {
            println("지난 주 당첨 번호를 입력해 주세요")
            val input = scanner.next()
            val numbers = stringToIntList(input)
                .map { i -> Number(i) }

            println("보너스 볼을 입력해 주세요")
            val bonusNumber = scanner.nextInt()

            return LastWeekLotto(numbers, Number(bonusNumber))
        }
    }
}