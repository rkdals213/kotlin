package lotto.domain

class Shop {
    companion object {
        private const val COST = 1000

        fun buyLotto(money: Int, manualLottoNumbers: List<List<Int>>): Lottos {
            require(moneyIsPositive(money)) {
                "잘못된 금액을 입력하셨습니다"
            }

            val count = calculateCount(money)
            check(moneyOverManualLottoCount(manualLottoNumbers, count)) {
                "구매한 금액보다 더 많은 수동 로또를 입력하였습니다"
            }

            return Lottos(count, manualLottoNumbers)
        }

        private fun moneyIsPositive(money: Int) =
            money >= 0

        private fun moneyOverManualLottoCount(manualLottoNumbers: List<List<Int>>, count: Int) =
            manualLottoNumbers.size <= count

        private fun calculateCount(money: Int) =
            money / COST
    }
}