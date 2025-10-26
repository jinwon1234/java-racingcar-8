package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.dto.GameRequestDto;
import racingcar.dto.GameResponseDto;
import racingcar.message.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;
import static racingcar.message.ErrorMessage.*;

class RacingGameServiceV1Test {

    RacingGameServiceV1 racingGameServiceV1 = new RacingGameServiceV1();


    @ParameterizedTest()
    @ValueSource(strings = {"pobi,woni,jun", "jinho,jinwo"})
    @DisplayName("게임 성공적으로 실행")
    void gameExecutionSuccess(String carNames) {
        // given
        GameRequestDto gameRequestDto = new GameRequestDto(carNames, 5);

        // when
        GameResponseDto gameResponseDto = racingGameServiceV1.executionGame(gameRequestDto);

        // then
        assertSoftly(softly -> {
            softly.assertThat(gameResponseDto.winnerNames()).containsAnyOf(carNames.split(","));
            softly.assertThat(gameResponseDto.executionResults()).hasSize(5);
        });
    }

    @ParameterizedTest()
    @ValueSource(strings = {"pobi,pobi,jun", "jinwo,jinwo"})
    @DisplayName("중복된 자동차 이름이 있는 경우 예외 반환")
    void gameExecutionFailDueToDuplicateName(String carNames) {
        // given
        GameRequestDto gameRequestDto = new GameRequestDto(carNames, 5);

        // when & then
        assertThatThrownBy(() -> racingGameServiceV1.executionGame(gameRequestDto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME);
    }
}
