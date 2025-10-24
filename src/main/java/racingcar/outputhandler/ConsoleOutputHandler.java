package racingcar.outputhandler;

import racingcar.dto.GameResponseDto;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void response(GameResponseDto gameResponseDto) {

        System.out.println(gameResponseDto.toString());
    }
}
