package bowling.score

class Pin(private val count: Int) {
    companion object {
        private const val MAX_COUNT = 10
    }

    init {
        require(count in 0..10) {
            "볼링핀은 0 ~ 10 사이로만 쓰러뜨릴 수 있습니다"
        }
    }

    fun count() = count

    fun plus(second: Pin) = Pin(this.count + second.count)

    fun available(): Boolean = count in 0..10

    fun isMiss(pin: Pin) = Math.addExact(count, pin.count) < 10

    fun isMaxCount() = count == MAX_COUNT

    fun isSpare(pin: Pin) = count + pin.count() == MAX_COUNT

    override fun toString() = if (count == 0) "-" else count.toString()
}