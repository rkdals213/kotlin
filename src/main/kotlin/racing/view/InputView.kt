package racing.view

import java.util.*

class InputView {
    companion object {
        private val scanner = Scanner(System.`in`)

        fun getNames(): String {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
            return scanner.next()
        }

        fun getTryCount(): Int {
            println("시도할 회수는 몇회인가요?")
            return scanner.nextInt()
        }
    }
}