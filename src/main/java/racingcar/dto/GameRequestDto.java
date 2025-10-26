package racingcar.dto;

import java.util.Arrays;
import java.util.List;

public record GameRequestDto(
        List<String> carNames,
        int gameCount
) {

    public GameRequestDto(String carNames, int gameCount) {
        this(Arrays.stream(carNames.split(",")).toList(), gameCount);
    }
}
