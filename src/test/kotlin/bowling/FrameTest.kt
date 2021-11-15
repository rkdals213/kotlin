package bowling

import bowling.domain.frame.LastFrame
import bowling.domain.frame.NormalFrame
import bowling.view.ResultPrintVisitor
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

        @Nested
        @DisplayName("ableToPitch 함수 호출 시")
        inner class ableToPitch {
            @Test
            @DisplayName("두번미만 pitch했으면 true를 리턴한다")
            fun ableToPitchTrue() {
                //given
                val first = 5
                val normalFrame = NormalFrame(1)

                //when
                normalFrame.pitch(first)

                //then
            }

            @Test
            @DisplayName("두번이상 pitch했으면 false를 리턴한다")
            fun ableToPitchFalse() {
                //given
                val first = 5
                val second = 5
                val normalFrame = NormalFrame(1)

                //when
                normalFrame.pitch(first)
                normalFrame.pitch(second)

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
                val current = lastFrame.current(ResultPrintVisitor())
                println(current)
            }

            @Test
            @DisplayName("frame의 총합이 10보다 작거나 같으면 성공한다")
            fun success2() {
                //given
                val first = 5
                val second = 5
                val bonus = 10
                val lastFrame = LastFrame(10)

                //when
                lastFrame.pitch(first)
                lastFrame.pitch(second)
                lastFrame.pitch(bonus)

                //then
                val current = lastFrame.current(ResultPrintVisitor())
                println(current)
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
        }
    }
}