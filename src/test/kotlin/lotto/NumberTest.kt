package lotto

import lotto.domain.Number
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NumberTest {

    @Nested
    @DisplayName("Number 클래스는 초기화할 때")
    inner class NumberInit {

        @Nested
        @DisplayName("범위를 벗어나면")
        inner class NumberOutOfRange {

            @Test
            @DisplayName("에러를 발생한다")
            fun numberThrowsException1() {
                //given

                //when

                //then
                assertThatThrownBy {
                    Number(0)
                }.isInstanceOf(IllegalArgumentException::class.java)
            }

            @Test
            @DisplayName("에러를 발생한다")
            fun numberThrowsException2() {
                //given

                //when

                //then
                assertThatThrownBy {
                    Number(47)
                }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }
}