package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.controller.RacingGameControllerV1;
import racingcar.dto.GameRequestDto;
import racingcar.dto.GameResponseDto;
import racingcar.inputhandler.ConsoleInputHandler;
import racingcar.inputhandler.InputHandler;
import racingcar.outputhandler.ConsoleOutputHandler;
import racingcar.outputhandler.OutputHandler;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceV1;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        RacingGameService racingGameService = new RacingGameServiceV1();
        RacingGameController racingGameController = new RacingGameControllerV1(racingGameService);

        GameRequestDto gameRequestDto = inputHandler.getInput();
        GameResponseDto gameResult = racingGameController.getGameResult(gameRequestDto);
        outputHandler.response(gameResult);
    }
}
