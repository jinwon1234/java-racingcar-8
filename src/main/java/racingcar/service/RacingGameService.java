package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.GameRequestDto;
import racingcar.dto.GameResponseDto;

import java.util.List;

public interface RacingGameService {

    GameResponseDto executionGame(GameRequestDto gameRequestDto);
}
