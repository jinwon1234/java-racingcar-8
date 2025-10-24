package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.CarPosition;
import racingcar.dto.GameExecutionResult;
import racingcar.dto.GameResponseDto;

import java.util.ArrayList;
import java.util.List;

public class RacingGameServiceV1 implements RacingGameService {

    @Override
    public GameResponseDto executionGame(List<Car> cars, int gameCount) {

        List<GameExecutionResult> gameExecutionResults = new ArrayList<>();

        for (int i=1; i<=gameCount; i++) {
            gameExecutionResults.add(new GameExecutionResult(i, executeRound(cars)));
        }

        List<String> winners = getWinner(gameExecutionResults.get(gameCount-1));


        return new GameResponseDto(winners, gameExecutionResults);
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
