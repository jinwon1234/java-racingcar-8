package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.GameResponseDto;

import java.util.List;

public interface RacingGameService {

    GameResponseDto executionGame(List<Car> cars, int gameCount);
}
