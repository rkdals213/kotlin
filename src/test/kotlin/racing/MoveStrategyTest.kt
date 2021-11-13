package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racing.strategy.DefaultMoveStrategy

class MoveStrategyTest {
    @Nested
    @DisplayName("MoveStrategy 인터페이스의")
    inner class moveStrategy {

        @Nested
        @DisplayName("DefaultStrategy 클래스는")
        inner class defaultStrategy {

            @Test
            @DisplayName("move함수 호출 시 6보다 큰 수가 들어오면 1을 리턴한다")
            fun moveSuccess() {
                //given
                val defaultMoveStrategy = DefaultMoveStrategy()

                //when
                val distance = defaultMoveStrategy.move(7)

                //then
                assertThat(distance).isEqualTo(1)
            }

            @Test
            @DisplayName("move함수 호출 시 6보다 작거나 같은 수가 들어오면 0을 리턴한다")
            fun moveFail() {
                //given
                val defaultMoveStrategy = DefaultMoveStrategy()

                //when
                val distance = defaultMoveStrategy.move(6)

                //then
                assertThat(distance).isEqualTo(0)
            }
        }
    }
}