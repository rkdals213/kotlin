package ladder.domain

class Participants(val participants: List<Participant>) {

    val size = participants.size

    fun indexOf(name: String) = participants.indexOf(Participant(name))
}