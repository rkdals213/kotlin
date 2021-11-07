package lotto.domain

class Shop {
    companion object {
        private const val COST = 1000

        fun buyLotto(money: Int, manualLottoNumbers: List<List<Int>>): Lottos {
            val count = calculateCount(money)
            return Lottos(count, manualLottoNumbers)
        }

        private fun calculateCount(money: Int): Int {
            return money / COST
        }
    }
}