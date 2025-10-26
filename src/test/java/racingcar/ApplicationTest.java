package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"      ", ""})
    @DisplayName("자동차 이름 입력값으로 빈값이 들어오면 실패")
    void carNamesBlankFail(String carNames) {
        assertThatThrownBy(()-> runException(carNames, "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,jinwon,jun", "pobi,,jun,,jinwo"})
    @DisplayName("자동차 이름이 1자 이상 5자 이하가 아니면 실패")
    void carNamesLengthFail(String carNames) {
        assertThatThrownBy(()-> runException(carNames, "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME);
    }


    @ParameterizedTest
    @ValueSource(strings = {"123안213", "12313녕", "하123세", "요", "0", "-1"})
    @DisplayName("숫자가 아닌 형태로 게임 횟수가 입력되거나 0이하라면 실패")
    void carNamesSizeFail(String gameCount) {
        assertThatThrownBy(()-> runException("pobi,woni", gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_GAME_COUNT);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
