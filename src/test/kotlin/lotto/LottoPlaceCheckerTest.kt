package lotto

import lotto.domain.Lottos
import lotto.domain.Number
import lotto.lottoPlace.LastWeekLotto
import lotto.lottoPlace.LottoPlace
import lotto.lottoPlace.LottoPlaceChecker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoPlaceCheckerTest {

    @Nested
    @DisplayName("LottoPlaceChecker의")
    inner class lottoPlaceChecker {

        @Nested
        @DisplayName("getLottoPlace 함수는")
        inner class getLottoPlace {

            @Test
            @DisplayName("로또번호가 일치하는지를 판별해 등수를 리스트 형태로 리턴한다다")
           fun returnsLottoPlaceList() {
                //given
                val lastWeekLottoNumbers = listOf(
                    Number(1),
                    Number(2),
                    Number(3),
                    Number(4),
                    Number(5),
                    Number(6)
                )

                val lastWeekLotto = LastWeekLotto(lastWeekLottoNumbers, Number(7))
                val lottoPlaceChecker = LottoPlaceChecker(lastWeekLotto)

                val myLottoNumbers = listOf(
                    1, 2, 3, 4, 5, 6,
                )
                val lottos = Lottos(1, listOf(myLottoNumbers))

                //when
                val lottoPlaces = lottoPlaceChecker.getLottoPlaces(lottos)

                //then
                assertThat(lottoPlaces[0]).isEqualTo(LottoPlace.FIRST)
            }
        }
    }
}