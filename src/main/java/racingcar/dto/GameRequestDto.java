package racingcar.dto;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public record GameRequestDto(
        String carNames,
        int gameCount
) {

    public List<Car> getCars() {

        return Arrays.stream(carNames.split(","))
                .map(name -> {
                    if (name.isBlank() || name.length() > 5) throw new IllegalArgumentException();
                    return new Car(name);
                }).toList();
    }
}
