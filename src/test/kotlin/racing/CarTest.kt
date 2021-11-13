package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.Cars
import racing.domain.Name
import racing.domain.Position

class CarTest {
    @Nested
    @DisplayName("Cars는")
    inner class carsTest {

        @Nested
        @DisplayName("이름 리스트를 생성자로 입력받으면")
        inner class getNameList {

            @Test
            @DisplayName("리스트의 사이즈만큼 자동차들을 만든다")
            fun makesCars() {
                //given
                val names = listOf(Name("Kang"), Name("Park"), Name("Kim"))

                //when
                val cars = Cars(names)

                //then
                assertThat(cars.participants()).size()
                        .isEqualTo(3)
            }
        }
    }


    @Nested
    @DisplayName("Car는")
    inner class carTest {

        @Nested
        @DisplayName("move 함수가 호출되었을 때")
        inner class move {

            @Test
            @DisplayName("입력한 값만큼 앞으로 간다")
            fun moveSuccess() { //given
                val car = Car(Name("Kang"), Position(0))

                //when
                car.move(1)

                //then
                assertThat(car.position()).isEqualTo(1)
            }
        }
    }
}