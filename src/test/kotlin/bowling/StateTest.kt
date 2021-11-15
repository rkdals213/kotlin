package bowling

import bowling.score.Pin
import bowling.state.finished.Miss
import bowling.state.finished.Spare
import bowling.state.State
import bowling.state.finished.Strike
import bowling.state.running.FirstPitch
import bowling.state.running.Ready
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class StateTest {

    @Nested
    @DisplayName("State들 중")
    inner class state {

        @Nested
        @DisplayName("Ready는")
        inner class ready {

            @Test
            @DisplayName("한번 pitch했을 때 10보다 작으면 FirstPitch를 반환한다")
            fun makeFirstPitch() {
                //given
                var state: State = Ready()

                //when
                state = state.pitch(Pin(3))

                //then
                assertThat(state).isInstanceOf(FirstPitch::class.java)
            }

            @Test
            @DisplayName("한번 pitch했을 때 10이면 Strike를 반환한다")
            fun makeStrike() {
                //given
                var state: State = Ready()

                //when
                state = state.pitch(Pin(10))

                //then
                assertThat(state).isInstanceOf(Strike::class.java)
            }
        }

        @Nested
        @DisplayName("FristPitch는")
        inner class firstPitch {

            @Test
            @DisplayName("pitch했을 때 총 합이 10보다 작으면 Miss를 반환한다")
            fun makeMiss() {
                //given
                var state: State = FirstPitch(Pin(3))

                //when
                state = state.pitch(Pin(3))

                //then
                assertThat(state).isInstanceOf(Miss::class.java)
            }

            @Test
            @DisplayName("한번 pitch했을 때 10이면 Strike를 반환한다")
            fun makeStrike() {
                //given
                var state: State = FirstPitch(Pin(3))

                //when
                state = state.pitch(Pin(7))

                //then
                assertThat(state).isInstanceOf(Spare::class.java)
            }
        }
    }
}