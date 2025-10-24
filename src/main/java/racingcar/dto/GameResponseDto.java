package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;

public record GameResponseDto(
        List<String> winnerNames,
        List<GameExecutionResult> results
) {

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (GameExecutionResult gameExecutionResult : results) {
            result.append(gameExecutionResult.toString()).append("\n");
        }

        result.append("최종 우승자 : ").append(String.join(", ", winnerNames));

        return result.toString();
    }
}
