package racingcar.dto;

public record CarPosition(
        String carName,
        int position
) {

    @Override
    public String toString() {
        return String.format("%s : %s", carName, "-".repeat(position));
    }
}
