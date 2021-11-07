package lotto.lottoPlace

enum class LottoPlace(
    private val correctNumberCount: Int,
    private val bonusNumberCorrect: Boolean,
    private val prize: Int
) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FORTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);

    companion object {
        fun findByCorrectNumberCount(count: Int, isBonusNumberCorrect: Boolean): LottoPlace {
            return values().find { lottoPlace ->
                correctNumberCountEqual(lottoPlace, count) && isBonusNumberCorrect(lottoPlace, isBonusNumberCorrect)
            } ?: NOTHING
        }

        private fun correctNumberCountEqual(lottoPlace: LottoPlace, count: Int): Boolean =
            lottoPlace.correctNumberCount == count

        private fun isBonusNumberCorrect(lottoPlace: LottoPlace, isBonusNumberCorrect: Boolean): Boolean =
            (lottoPlace.bonusNumberCorrect && isBonusNumberCorrect) == lottoPlace.bonusNumberCorrect

        fun valuesWithoutNothing(): List<LottoPlace> = values()
            .asList()
            .subList(0, 5)
    }

    fun prize(): Int = prize

    fun correctCount(): Int = correctNumberCount

    fun bonusNumberCorrect(): Boolean = bonusNumberCorrect
}