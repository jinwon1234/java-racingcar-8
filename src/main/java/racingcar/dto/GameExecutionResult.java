package racingcar.dto;

import java.util.List;

public record GameExecutionResult(
        int gameNumber,
        List<CarPosition> carPositions
) {

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (CarPosition carPosition : carPositions) {
            result.append(carPosition.toString() + "\n");
        }

        return result.toString();
    }
}
