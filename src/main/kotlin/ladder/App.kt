package ladder

import ladder.domain.*
import ladder.view.*

fun main() {
    val names = getParticipants()
    val results = getResults()
    val height = getLadderHeight()

    val participants = Participants(names.map { Participant(it) })
    val ladder = Ladder(participants.size, height)
    val prizes = Prizes(results.map { Prize(it) })

    showParticipants(participants)
    showLadder(ladder)
    showPrize(prizes)

    while (true) {
        val participant = getParticipant()

        if (participant == "all") {
            showAllResult(participants, ladder, prizes)
            return
        }

        val position = participants.indexOf(participant)
        val resultIndex = ladder.getResult(position)

        showResult(participant, prizes, resultIndex)
    }
}
