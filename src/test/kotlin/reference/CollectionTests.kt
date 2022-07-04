package reference

import org.junit.jupiter.api.Test

class CollectionTests {

    @Test
    fun test01() {
        val list1: List<String> = listOf("a", "b", "c", "d", "e")
        val list2: List<String> = listOf("c", "e", "f")

        val set1 = list1 intersect list2
        val set2 = list1 subtract list2
        val set3 = list1 union list2

        val pairs = list1 zip list2

        set1.printAllElement()
        println()
        set2.printAllElement()
        println()
        set3.printAllElement()
        println()
        println(pairs)
    }

    private fun Collection<String>.printAllElement() = forEach { print("$it ") }
}