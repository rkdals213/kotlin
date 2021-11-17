package bowling.domain.frame

class Frames(private val name: Name) {
    private val frames: MutableList<Frame> = mutableListOf(NormalFrame(1))

    fun pitch(count: Int) {
        val last = frames.last()
        val frame = last.pitch(count)

        if (frame != last) {
            frames.add(frame)
        }
    }

    fun ableToPitch() = frames.last()
        .gameFinished()
        .not()

    fun current() = frames.toList()

    fun name() = name

    fun currentFrameNumber() = frames.last()
        .number()
}

class Name(private val name: String) {

    init {
        require(name.length in 3..4)
    }

    override fun toString() = name
}