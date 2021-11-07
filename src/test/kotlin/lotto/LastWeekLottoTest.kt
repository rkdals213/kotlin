package lotto

import lotto.lottoPlace.LastWeekLotto
import lotto.domain.Number
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LastWeekLottoTest {
    @Nested
    @DisplayName("LastWeekLotto의")
    inner class lastWeekLotto {
        private val lastWeekLotto: LastWeekLotto = LastWeekLotto(
            listOf(
                Number(1),
                Number(2),
                Number(3),
                Number(4),
                Number(5),
                Number(6)
            ), Number(45)
        )

        @Nested
        @DisplayName("contains 함수는")
        inner class containsFunction {
            @Test
            @DisplayName("숫자가 포함됬는지를 리턴한다: true")
            fun returnsBoolean() {
                //given
                val given = Number(5)

                //when
                val contains = lastWeekLotto.contains(given)
                //then

                assertThat(contains).isTrue
            }

            @Test
            @DisplayName("숫자가 포함됬는지를 리턴한다: false")
            fun returnsBoolean2() {
                //given
                val given = Number(7)

                //when
                val contains = lastWeekLotto.contains(given)
                //then

                assertThat(contains).isFalse
            }
        }

        @Nested
        @DisplayName("isBonusNumberMatch 함수는")
        inner class isBonusNumberMatchFunction {
            @Test
            @DisplayName("bonus 번호가 맞는지 리턴한다: true")
            fun returnsBoolean() {
                //given
                val given = Number(45)

                //when
                val match = lastWeekLotto.isBonusNumberMatch(given)
                //then

                assertThat(match).isTrue
            }

            @Test
            @DisplayName("bonus 번호가 맞는지 리턴한다: false")
            fun returnsBoolean2() {
                //given
                val given = Number(7)

                //when
                val match = lastWeekLotto.isBonusNumberMatch(given)
                //then

                assertThat(match).isFalse
            }
        }
    }
}