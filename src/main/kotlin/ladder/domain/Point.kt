package ladder.domain

import java.util.function.Function

enum class Point : Function<Int, Int> {
    LEFT {
        override fun apply(i: Int): Int = i - 1
    },
    DOWN {
        override fun apply(i: Int): Int = i
    },
    RIGHT {
        override fun apply(i: Int): Int = i + 1
    }
    ;

    companion object {
        fun getByIndex(index: Int) = values()[index]
    }
}