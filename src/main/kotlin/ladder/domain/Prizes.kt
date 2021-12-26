package ladder.domain

class Prizes(val prizes: List<Prize>) {

    fun prizeOf(index: Int) = prizes[index]
}
