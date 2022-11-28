package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumberTest {

    @DisplayName("0부터 9까지 숫자가 아닌 정수를 문자열 매개값으로 하여 Number 객체를 생성하면 오류가 발생한다.")
    @ValueSource(strings = {"", "a", "0", "10"})
    @ParameterizedTest
    void makeNumberWithWrongInput(String input) {
        assertThatThrownBy(() -> {
            new GameNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0부터 9까지 숫자를 문자열 타입 매개값으로하면 Number 객체가 정상적으로 생성된다")
    @ValueSource(strings = {"1", "9"})
    @ParameterizedTest
    void makeNumberWithCorrectInput(String input) {
        GameNumber gameNumber = new GameNumber(input);

        System.out.println(gameNumber.getNumber());

        assertThat(gameNumber.getNumber()).isBetween(1, 9);
    }
}