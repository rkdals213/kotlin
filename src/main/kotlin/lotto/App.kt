package lotto

import lotto.domain.Shop
import lotto.lottoPlace.LottoPlaceChecker
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val cost = InputView.getCost()
    val countOfManualBuy = InputView.getCountOfManualBuy()
    val manualLottoNumbers = InputView.getManualLottoNumbers(countOfManualBuy)
    val lottos = Shop.buyLotto(cost, manualLottoNumbers)

    OutputView.printLottoNumbers(countOfManualBuy, lottos)

    val lastWeekLotto = InputView.getLastWeekLottoNumber()
    val lottoPlaceChecker = LottoPlaceChecker(lastWeekLotto)
    val lottoPlaces = lottoPlaceChecker.getLottoPlaces(lottos)

    OutputView.printResult(lottoPlaces)
    OutputView.printWinningRate(lottos, lottoPlaces)
}