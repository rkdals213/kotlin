package lotto.lottoPlace

import lotto.domain.Lotto
import lotto.domain.Lottos

class LottoPlaceChecker(
    private val lastWeekLotto: LastWeekLotto
) {
    fun getLottoPlaces(lottos: Lottos): List<LottoPlace> {
        return lottos.lottos().map { lotto -> getLottoPlace(lotto) }
    }

    private fun getLottoPlace(lotto: Lotto): LottoPlace {
        val countMatchNumbers = lotto.countMatchNumbers(lastWeekLotto)
        val bonusNumberCorrect = lotto.isBonusNumberCorrect(lastWeekLotto)
        return LottoPlace.findByCorrectNumberCount(countMatchNumbers, bonusNumberCorrect)
    }
}