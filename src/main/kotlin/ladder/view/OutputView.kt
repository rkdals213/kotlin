package ladder.view

import ladder.domain.*

fun showParticipants(participants: Participants) {
    participants.participants
        .forEach {
            printTextInFormat(it.name)
        }
        .also { println() }
}

fun showLadder(ladder: Ladder) {
    ladder.ladderLines
        .forEach { ladderLine ->
            ladderLine.points
                .points
                .forEach { point ->
                    showPoint(point)
                }

            println()
        }
}

private fun showPoint(point: Point) {
    when (point) {
        Point.LEFT -> print("--|  ")
        Point.RIGHT -> print("  |--")
        Point.DOWN -> print("  |  ")
    }
}

fun showPrize(prizes: Prizes) {
    prizes.prizes
        .forEach { printTextInFormat(it.prize) }
        .also { println() }
}

private fun printTextInFormat(text: String) {
    print("  ${text.padEnd(3, ' ')}")
}

fun showAllResult(
    participants: Participants,
    ladder: Ladder,
    prizes: Prizes
) {
    println("실행 결과")
    participants.participants
        .forEach {
            val position = participants.indexOf(it.name)
            val resultIndex = ladder.getResult(position)

            showResult(it.name, prizes, resultIndex)
        }
}

fun showResult(participant: String, prizes: Prizes, resultIndex: Int) {
    println(
        "$participant : ${
            prizes.prizeOf(resultIndex)
                .prize
        }"
    )
}
