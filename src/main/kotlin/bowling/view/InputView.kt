package bowling.view

import java.util.*

class InputView {
    companion object {
        private val scanner = Scanner(System.`in`)

        fun getPlayerName(): String {
            print("플레이어 이름은(3 english letters)?: ")
            return scanner.next()
        }

        fun getPitchCount(frameNumber: Int): Int {
            print("${frameNumber}프레임 투구 : ")
            return scanner.nextInt()
        }
    }
}