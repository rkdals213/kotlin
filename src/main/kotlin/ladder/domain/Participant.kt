package ladder.domain

class Participant(val name: String) {
    init {
        require(nameInMaxLength()) { "이름의 최대 길이는 3자를 넘을 수 없습니다" }
    }

    private fun nameInMaxLength() = name.length <= MAX_NAME_LENGTH

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Participant

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        private const val MAX_NAME_LENGTH = 3
    }
}