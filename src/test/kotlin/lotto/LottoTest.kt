package lotto

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Number
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoTest {

    @Nested
    @DisplayName("Lotto를 초기화할 때")
    inner class LottoInit {

        @Nested
        @DisplayName("로또번호를 입력하지 않으면")
        inner class WithOutInput {
            @Test
            @DisplayName("임의의 6개의 숫자를 로또번호로 만든다")
            fun makesSixRandomNumbers() {
                //given
                val lotto = Lotto()

                //when

                //then
                val lottoSize = lotto.lottoNumbers
                    .size

                assertThat(lottoSize).isEqualTo(6)
            }
        }

        @Nested
        @DisplayName("로또번호를 입력하면")
        inner class WithInput {
            @Test
            @DisplayName("입력한 6개의 숫자로 로또를 만든다")
            fun initWithInput() {
                //given
                val lottoNumbers = listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )

                //when

                //then
                val lotto = Lotto(lottoNumbers)

                assertThat(lotto.lottoNumbers).containsExactlyElementsOf(lottoNumbers)
            }
        }

        @Nested
        @DisplayName("로또번호를 기준보다 많이 입력하면")
        inner class WithInputOver {
            @Test
            @DisplayName("에러를 발생한다")
            fun initWithInput() {
                //given
                val lottoNumbers = listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6),
                    Number(7)
                )

                //when

                //then
                assertThatThrownBy {
                    Lotto(lottoNumbers)
                }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }
}