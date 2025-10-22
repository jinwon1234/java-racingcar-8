package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.message.ErrorMessage.*;

class GameRequestDtoTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi,woni,jun,jinwo", "jinwo"})
    @DisplayName("getCars() 성공 - 정상적인 carNames")
    void getCarsSuccess(String carNames) {

        // given
        GameRequestDto gameRequestDto = new GameRequestDto(carNames, 5);

        // when
        List<Car> cars = gameRequestDto.getCars();

        // then
        assertThat(cars.size()).isEqualTo(carNames.split(",").length);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woniii,jun", "pobi,,jun,jinwo"})
    @DisplayName("getCars() 실패 - blank 혹은 carName 중 하나가 6자 이상")
    void getCarsFail(String carNames) {

        // given
        GameRequestDto gameRequestDto = new GameRequestDto(carNames, 5);

        // when & then
        assertThatThrownBy(() -> gameRequestDto.getCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME);
    }



}
