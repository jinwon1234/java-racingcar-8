package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.CarPosition;
import racingcar.dto.GameExecutionResult;
import racingcar.dto.GameRequestDto;
import racingcar.dto.GameResponseDto;

import java.util.ArrayList;
import java.util.List;

import static racingcar.message.ErrorMessage.DUPLICATE_CAR_NAME;
import static racingcar.message.ErrorMessage.INVALID_CAR_NAME;

public class RacingGameServiceV1 implements RacingGameService {

    @Override
    public GameResponseDto executionGame(GameRequestDto gameRequestDto) {


        int gameCount = gameRequestDto.gameCount();
        List<Car> cars = parseCars(gameRequestDto.carNames());

        List<GameExecutionResult> gameExecutionResults = new ArrayList<>();

        for (int i=1; i<=gameCount; i++) {
            gameExecutionResults.add(new GameExecutionResult(i, executeRound(cars)));
        }

        List<String> winners = getWinner(gameExecutionResults.get(gameCount-1));


        return new GameResponseDto(winners, gameExecutionResults);
    }

    private List<Car> parseCars(List<String> carNames) {

        List<Car> cars = carNames.stream()
                .distinct()
                .map(name -> {
                    if (name.isBlank() || name.length() > 5) throw new IllegalArgumentException(INVALID_CAR_NAME);
                    return new Car(name);
                }).toList();

        if (cars.size() != carNames.size()) throw new IllegalArgumentException(DUPLICATE_CAR_NAME);

        return cars;
    }

    private List<CarPosition> executeRound(List<Car> cars) {

        List<CarPosition> positions = new ArrayList<>();

        for (Car car : cars) {
            car.move();
            positions.add(new CarPosition(car.getName(), car.getPosition()));
        }

        return positions;
    }

    private List<String> getWinner(GameExecutionResult gameExecutionResult) {
        List<CarPosition> carPositions = gameExecutionResult.carPositions();

        int maxPosition = carPositions.stream()
                .mapToInt(CarPosition::position)
                .max().orElse(0);

        return carPositions.stream()
                .filter(position -> position.position() == maxPosition)
                .map(CarPosition::carName).toList();
    }
}
