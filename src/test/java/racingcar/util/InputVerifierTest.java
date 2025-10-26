package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.INVALID_GAME_COUNT;
import static racingcar.message.ErrorMessage.INVALID_INPUT;

class InputVerifierTest {


    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi,woni,jun,ibop", "pobi"})
    @DisplayName("정상적인 입력값 들어오면 그대로 입력값을 반환")
    void verifyInputSuccess(String input) {

        // when
        String result = InputVerifier.validateInput(input);

        // then
        assertThat(result).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"      ", ""})
    @DisplayName("비정상적인(빈값) 입력값 들어오면 IllegalArgumentException 반환")
    void verifyInputFail(String input) {

        // when & then
        assertThatThrownBy(()->InputVerifier.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "10", "10403123"})
    @DisplayName("숫자 형태의 입력값이 들어오면 int 형태로 변환 후 반환")
    void safeParseIntSuccess(String input) {

        // when
        int result = InputVerifier.safeParseInt(input);

        // then
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"5안녕", "하세요10", "1040이진원입니다.3123, -1, 0"})
    @DisplayName("숫자 형태의 입력값이 안들어오거나 0이하라면 IllegalArgumentException 반환")
    void safeParseIntFail(String input) {

        // when & then
        assertThatThrownBy(()->InputVerifier.safeParseInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_GAME_COUNT);
    }
}
