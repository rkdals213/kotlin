package racing.domain

class Car(
        private val name: Name, private var position: Position = Position(0)
) {
    fun move(distance: Int) {
        this.position = this.position.go(distance)
    }

    fun position() = position.position()

    fun participant() = name
}

class Name(private val name: String) {

    companion object {
        private const val NAME_LENGTH_MIN = 3
    }

    init {
        require(name.length >= NAME_LENGTH_MIN) {
            "이름은 최소 3글자 이상이여야 합니다"
        }
    }

    override fun toString(): String {
        return name
    }
}

class Position(private val position: Int) {
    init {
        require(position >= 0) {
            "시작점은 원점보다 앞이여야 합니다"
        }
    }

    fun go(distance: Int) = Position(this.position + distance)

    fun position() = position
}