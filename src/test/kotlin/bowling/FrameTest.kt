package bowling

import bowling.domain.frame.LastFrame
import bowling.domain.frame.NormalFrame
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class FrameTest {
    @Nested
    @DisplayName("NoramlFrame은")
    inner class normalFrame {

        @Nested
        @DisplayName("pitch 함수 호출 시")
        inner class pitch {

            @Test
            @DisplayName("frame의 총합이 10보다 작거나 같으면 성공한다")
            fun success() {
                //given
                val first = 5
                val second = 5
                val normalFrame = NormalFrame(1)

                //when
                normalFrame.pitch(first)
                normalFrame.pitch(second)

                //then
            }

            @Test
            @DisplayName("frame의 총합이 10보다 크면 실패한다")
            fun fail() {
                //given
                val first = 5
                val second = 6
                val normalFrame = NormalFrame(1)

                //when
                normalFrame.pitch(first)
                assertThatThrownBy { normalFrame.pitch(second) }

                //then
            }
        }
    }

    @Nested
    @DisplayName("LastFrame은")
    inner class lastFrame {
        @Nested
        @DisplayName("pitch 함수 호출 시")
        inner class pitch {

            @Test
            @DisplayName("frame의 총합이 10보다 작거나 같으면 성공한다")
            fun success() {
                //given
                val first = 5
                val second = 3
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                lastFrame.pitch(second)

                //then
            }

            @Test
            @DisplayName("frame의 총합이 10보다 작거나 같으면 성공한다")
            fun success2() {
                //given
                val first = 5
                val second = 5
                val bonus = 6
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                lastFrame.pitch(second)
                lastFrame.pitch(bonus)

                //then
            }

            @Test
            @DisplayName("frame의 총합이 10보다 작거나 같으면 성공한다")
            fun success3() {
                //given
                val first = 10
                val second = 10
                val bonus = 6
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                lastFrame.pitch(second)
                lastFrame.pitch(bonus)

                //then
            }

            @Test
            @DisplayName("frame의 총합이 10보다 작거나 같으면 성공한다")
            fun success4() {
                //given
                val first = 10
                val second = 3
                val bonus = 3
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                lastFrame.pitch(second)
                lastFrame.pitch(bonus)

                //then
                assertThat(lastFrame.gameFinished()).isTrue
            }

            @Test
            @DisplayName("frame의 총합이 10보다 크면 실패한다")
            fun fail() {
                //given
                val first = 5
                val second = 6
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                assertThatThrownBy { lastFrame.pitch(second) }

                //then
            }

            @Test
            @DisplayName("frame의 총합이 10보다 크면 실패한다")
            fun fail2() {
                //given
                val first = 10
                val second = 6
                val bonus = 6
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                lastFrame.pitch(second)
                assertThatThrownBy { lastFrame.pitch(bonus) }

                //then
            }

            @Test
            @DisplayName("보너스가 없는 상태에서 던지면 에러가 발생한다")
            fun fail3() {
                //given
                val first = 1
                val second = 1
                val bonus = 6
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                lastFrame.pitch(second)
                assertThatThrownBy { lastFrame.pitch(bonus) }

                //then
            }
        }
    }
}