package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.GameResponseDto;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.*;

class RacingGameServiceV1Test {

    RacingGameServiceV1 racingGameServiceV1 = new RacingGameServiceV1();


    @Test
    @DisplayName("게임 성공적으로 실행")
    void gameExecutionSuccess() {
        // given
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        // when
        GameResponseDto gameResponseDto = racingGameServiceV1.executionGame(cars, 5);

        // then
        assertSoftly(softly -> {
            softly.assertThat(gameResponseDto.winnerNames()).containsAnyOf("pobi", "woni", "jun");
            softly.assertThat(gameResponseDto.executionResults()).hasSize(5);
        });
    }
}
