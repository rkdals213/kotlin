package bowling.score

class Score(private val score: Int, private val left: Int) {
    companion object {
        fun strike(): Score {
            return Score(Pin.MAX_COUNT, 2)
        }

        fun spare(): Score {
            return Score(Pin.MAX_COUNT, 1)
        }

        fun miss(pins: Int): Score {
            checkMissPinsSum(pins)
            return Score(pins, 0)
        }

        private fun checkMissPinsSum(pins: Int) {
            require(pins < Pin.MAX_COUNT)
        }
    }

    fun canCalculateScore(): Boolean {
        return left == 0
    }

    fun score(): Int {
        require(canCalculateScore())
        return score
    }

    fun addPin(pin: Pin): Score {
        require(canCalculateScore().not())
        return Score(score + pin.count(), left - 1)
    }
}