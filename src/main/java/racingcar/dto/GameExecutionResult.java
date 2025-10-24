package racingcar.dto;

import java.util.List;

public record GameExecutionResult(
        int gameNumber,
        List<CarPosition> carPositions
) {
}
