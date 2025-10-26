package racingcar.outputhandler;

import racingcar.dto.GameExecutionResult;
import racingcar.dto.GameResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void response(GameResponseDto gameResponseDto) {

        List<GameExecutionResult> executionResults = gameResponseDto.executionResults();
        List<String> winnerNames = gameResponseDto.winnerNames();

        String result = """
        실행 결과
       
        %s
        최종 우승자 : %s
        """.formatted(
                executionResults.stream()
                        .map(GameExecutionResult::toString)
                        .collect(Collectors.joining("\n\n")),

                String.join(", ", winnerNames)
        );

        System.out.println(result);
    }
}
