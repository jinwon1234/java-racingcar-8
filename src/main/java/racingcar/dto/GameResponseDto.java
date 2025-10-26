package racingcar.dto;

import java.util.List;

public record GameResponseDto(
        List<String> winnerNames,
        List<GameExecutionResult> executionResults
) {
}
