package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;

public record GameExecutionResult(
        int gameNumber,
        List<CarPosition> carPositions
) {

    @Override
    public String toString() {

       return carPositions.stream()
               .map(CarPosition::toString)
               .collect(Collectors.joining("\n"));
    }
}
