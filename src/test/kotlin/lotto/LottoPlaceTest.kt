package lotto

import lotto.lottoPlace.LottoPlace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoPlaceTest {

    @Nested
    @DisplayName("LottoPlace는")
    inner class lottoPlace {

        @Nested
        @DisplayName("correctNumber를 가지고")
        inner class withCorrectNumber {

            @Test
            @DisplayName("등수를 판별한다: first")
            fun fistPlace() {
                //given
                val count = 6
                val isBonusNumberCorrect = false

                //when
                val lottoPlace = LottoPlace.findByCorrectNumberCount(count, isBonusNumberCorrect)

                //then

                assertThat(lottoPlace).isEqualTo(LottoPlace.FIRST)
            }

            @Test
            @DisplayName("등수를 판별한다: second")
            fun secondPlace() {
                //given
                val count = 5
                val isBonusNumberCorrect = true

                //when
                val lottoPlace = LottoPlace.findByCorrectNumberCount(count, isBonusNumberCorrect)

                //then

                assertThat(lottoPlace).isEqualTo(LottoPlace.SECOND)
            }

            @Test
            @DisplayName("등수를 판별한다: third")
            fun thirdPlace() {
                //given
                val count = 5
                val isBonusNumberCorrect = false

                //when
                val lottoPlace = LottoPlace.findByCorrectNumberCount(count, isBonusNumberCorrect)

                //then

                assertThat(lottoPlace).isEqualTo(LottoPlace.THIRD)
            }
        }
    }
}