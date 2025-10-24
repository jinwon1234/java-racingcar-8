package racingcar.controller;

import racingcar.dto.GameRequestDto;
import racingcar.dto.GameResponseDto;

public interface RacingGameController {

    GameResponseDto getGameResult(GameRequestDto gameRequestDto);
}
