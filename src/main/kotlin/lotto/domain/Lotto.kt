package lotto.domain

import lotto.lottoPlace.LastWeekLotto
import java.util.stream.Stream
import kotlin.streams.toList

class Lotto(private val lottoNumbers: List<Number>) {
    constructor() : this(Stream.iterate(1) { t -> t + 1 }
        .limit(MAX_NUMBER)
        .map { Number(it) }
        .toList()
        .shuffled()
        .subList(0, LOTTO_NUMBER_COUNT)
    )

    companion object {
        private const val MAX_NUMBER = 45L
        private const val LOTTO_NUMBER_COUNT = 6
        private const val COST = 1000
    }

    init {
        require(lottoNumbers.distinct().size == 6) {
            "로또 번호의 갯수는 중복되지 않고 6개여야 합니다"
        }
    }

    fun countMatchNumbers(lastWeekLotto: LastWeekLotto): Int {
        return lottoNumbers.count { number ->
            lastWeekLotto.contains(number)
        }
    }

    fun isBonusNumberCorrect(lastWeekLotto: LastWeekLotto): Boolean {
        return lottoNumbers.any { number ->
            lastWeekLotto.isBonusNumberMatch(number)
        }
    }

    fun lottoNums(): List<Number> {
        return lottoNumbers
    }

    fun cost(): Int {
        return COST
    }
}