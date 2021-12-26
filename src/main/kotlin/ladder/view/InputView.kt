package ladder.view

import java.util.*

private val SCANNER = Scanner(System.`in`)

fun getParticipants(): List<String> {
    println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)")
    return stringToList(SCANNER.next())
}

private fun stringToList(input: String) = input.split(",")
    .toList()

fun getResults(): List<String> {
    println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)")
    return stringToList(SCANNER.next())
}

fun getLadderHeight(): Int {
    println("최대 사다리 높이는 몇 개인가요?")
    return SCANNER.nextInt()
}

fun getParticipant(): String {
    println("결과를 보고 싶은 사람은?")
    return SCANNER.next()
}