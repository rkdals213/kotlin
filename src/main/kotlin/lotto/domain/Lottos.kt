package lotto.domain

import java.util.stream.Stream
import kotlin.streams.toList

class Lottos(
    private val count: Int,
    manualLottoNumbers: List<List<Int>>
) {
    private val lottos: List<Lotto> = manualLottoNumbers.map { list -> Lotto(list.map { i -> Number(i) }) }
        .plus(
            Stream.generate { Lotto() }
                .limit(countMinusManualSize(manualLottoNumbers))
                .toList()
        )

    private fun countMinusManualSize(manualLottoNumbers: List<List<Int>>) =
        count.toLong() - manualLottoNumbers.size

    fun lottos(): List<Lotto> {
        return lottos
    }

    fun count(): Int {
        return count
    }

    fun cost(): Int {
        return lottos.sumOf { lotto -> lotto.cost() }
    }
}