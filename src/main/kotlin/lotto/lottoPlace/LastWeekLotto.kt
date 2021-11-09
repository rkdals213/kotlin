package lotto.lottoPlace

import lotto.domain.Number

class LastWeekLotto(
    private val lottoNumbers: List<Number>,
    private val bonusNumber: Number
) {
    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }

    init {
        require(lottoNumbers.distinct().size == LOTTO_NUMBER_COUNT) {
            "로또 번호의 갯수는 중복되지 않고 6개여야 합니다"
        }
    }

    fun contains(number: Number) =
        lottoNumbers.contains(number)

    fun isBonusNumberMatch(number: Number) =
        bonusNumber == number

}