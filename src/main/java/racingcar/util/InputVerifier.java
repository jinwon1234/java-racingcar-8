package racingcar.util;

import static racingcar.message.ErrorMessage.INVALID_GAME_COUNT;
import static racingcar.message.ErrorMessage.INVALID_INPUT;

public final class InputVerifier {

    public static String validateInput(String input) {
        if (input == null || input.isBlank()) throw new IllegalArgumentException(INVALID_INPUT);
        return input;
    }

    public static int safeParseInt(String input) {
        try {
            int gameCount = Integer.parseInt(input);
            if (gameCount < 1) throw new IllegalArgumentException(INVALID_GAME_COUNT);
            return gameCount;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_GAME_COUNT);
        }
    }
}
