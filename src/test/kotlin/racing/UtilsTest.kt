package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racing.domain.Name
import racing.utils.Names

class UtilsTest {

    @Nested
    @DisplayName("Names 클래스의")
    inner class names {

        @Nested
        @DisplayName("listOfName 클래스는")
        inner class getStrings {

            @Test
            @DisplayName("nameString을 Names의 리스트형태로 반환한다")
            fun makesNameList() {
                //given
                val nameString = "Kang,Kim,Park"

                //when
                val names = Names(nameString).listOfName()

                //then
                assertThat(names[0]::class).isEqualTo(Name::class)
                assertThat(names).size()
                        .isEqualTo(3)
            }
        }
    }
}