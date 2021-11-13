package lotto.view

import lotto.domain.Lottos
import lotto.lottoPlace.LottoPlace

class OutputView {
    companion object {
        fun printLottoNumbers(countOfManualBuy: Int, lottos: Lottos) {
            println("수동으로 ${countOfManualBuy}장, 자동으로 ${lottos.count() - countOfManualBuy}개를 구매했습니다.")

            for (lotto in lottos.lottos()) {
                println(lotto.lottoNums())
            }
        }

        fun printResult(lottoPlaces: List<LottoPlace>) {
            println("당첨 통계")
            println("-----------------------")

            val countMap = lottoPlaces.groupingBy { it }
                .eachCount()

            for (lottoPlace in LottoPlace.valuesWithoutNothing()) {
                val text = createLottoPlaceOutputText(lottoPlace, countMap)
                println(text)
            }
        }

        private fun createLottoPlaceOutputText(lottoPlace: LottoPlace, countMap: Map<LottoPlace, Int>): StringBuilder {
            val text = StringBuilder("${lottoPlace.correctCount()}개 일치")
            if (lottoPlace.bonusNumberCorrect()) {
                text.append(", 보너스 볼 일치")
            }
            text.append("(${lottoPlace.prize()}원) - ${countMap[lottoPlace] ?: 0}개")
            return text
        }

        fun printWinningRate(lottos: Lottos, lottoPlaces: List<LottoPlace>) {
            val totalCost = lottos.cost()
                .toBigDecimal()

            val totalPrize = lottoPlaces.sumOf { it.prize() }
                .toBigDecimal()

            println("총 수익률은 ${totalPrize.divide(totalCost)}입니다")
        }
    }
}