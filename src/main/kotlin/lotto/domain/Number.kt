package lotto.domain

class Number(
    private val number: Int
) {
    companion object {
        private const val MIN_NUMBER = 1;
        private const val MAX_NUMBER = 45;
    }

    init {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            "로또번호는 $MIN_NUMBER ~ $MAX_NUMBER 사이여야 합니다"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

    override fun toString(): String {
        return number.toString()
    }
}