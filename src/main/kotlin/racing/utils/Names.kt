package racing.utils

import racing.domain.Name

class Names(private val namesString: String) {
    fun listOfName() = namesString.split(",")
            .toList()
            .map { Name(it) }
}