package lotto.lottoPlace

enum class LottoPlace(
    val correctNumberCount: Int,
    val bonusNumberCorrect: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(0, false, 0);

    companion object {
        fun findByCorrectNumberCount(count: Int, isBonusNumberCorrect: Boolean) =
            values().find { lottoPlace ->
                correctNumberCountEqual(lottoPlace, count) && isBonusNumberCorrect(lottoPlace, isBonusNumberCorrect)
            } ?: NOTHING


        private fun correctNumberCountEqual(lottoPlace: LottoPlace, count: Int) =
            lottoPlace.correctNumberCount == count

        private fun isBonusNumberCorrect(lottoPlace: LottoPlace, isBonusNumberCorrect: Boolean) =
            (lottoPlace.bonusNumberCorrect && isBonusNumberCorrect) == lottoPlace.bonusNumberCorrect

        fun valuesWithoutNothing(): List<LottoPlace> = values()
            .asList()
            .subList(0, 5)
    }
}