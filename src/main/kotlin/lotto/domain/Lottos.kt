package lotto.domain

import java.util.stream.Stream
import kotlin.streams.toList

class Lottos(
    private val count: Int, manualLottoNumbers: List<List<Int>>
) {
    private val lottos: List<Lotto> = manualLottoNumbers.map { list -> Lotto(list.map { i -> Number(i) }) }
            .plus(Stream.generate { Lotto() }
                    .limit(countMinusManualSize(manualLottoNumbers))
                    .toList())

    init {
        require(totalCountOverTheManualSize(manualLottoNumbers)) {
            "수동 입력한 로또 번호의 갯수가 전체 구매 갯수보다 작거나 같아야합니다"
        }
    }

    private fun totalCountOverTheManualSize(manualLottoNumbers: List<List<Int>>) = countMinusManualSize(manualLottoNumbers) >= 0

    private fun countMinusManualSize(manualLottoNumbers: List<List<Int>>) = count.toLong() - manualLottoNumbers.size

    fun lottos() = lottos

    fun count() = count

    fun cost() = lottos.sumOf { lotto -> lotto.cost }
}