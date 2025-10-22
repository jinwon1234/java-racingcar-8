package racingcar.inputhandler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.GameRequestDto;
import racingcar.util.InputVerifier;

import static racingcar.message.Message.*;

public class ConsoleInputHandler implements InputHandler{

    @Override
    public GameRequestDto getInput() {

        System.out.println(START_MESSAGE);
        String carNames = InputVerifier.validateInput(Console.readLine().trim());

        System.out.println(REQUEST_GAME_COUNT_MESSAGE);
        int gameCount = InputVerifier.safeParseInt(Console.readLine().trim());

        return new GameRequestDto(carNames, gameCount);
    }

}
