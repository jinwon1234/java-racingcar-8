package racingcar.controller;

import racingcar.dto.GameRequestDto;
import racingcar.dto.GameResponseDto;
import racingcar.service.RacingGameService;

public class RacingGameControllerV1 implements RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameControllerV1(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    @Override
    public GameResponseDto getGameResult(GameRequestDto gameRequestDto) {

        return racingGameService.executionGame(gameRequestDto);
    }
}
