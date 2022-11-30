package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumberTest {

    @DisplayName("GameNumber 정적 팩토리 메서드의 메개변수로 List<Integer> 타입의 값을 입력하면 GameNumber 객체가 생성된다")
    @Test
    void constructGameNumber() {
        List<Integer> randomNumbers = List.of(1,2,3);

        GameNumber gameNumber = GameNumber.of(randomNumbers);
        for (GameDigit digit : gameNumber.getGameNumber()) {
            System.out.println(digit);
            assertThat(digit.getDigit()).isBetween(1,3);
        }
    }

    @DisplayName("야구 숫자로 '공백', '문자', '범위 초과 수'를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"", "a23", "012", "112"})
    @ParameterizedTest
    void constructGameNumberWithWrongInput(String input) {
        assertThatThrownBy(() -> {
            GameNumber.of(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("야구 숫자로 '중복된 수' '세자리가 아닌 숫자'를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"112", "12", "1234"})
    @ParameterizedTest
    void constructGameNumberWithWrongNumber(String input) {
        assertThatThrownBy(() -> {
            GameNumber.of(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("야구 숫자로 올바른 수를 입력하면 사용자 번호 객체가 생성된다.")
    @ValueSource(strings = {"123", "456", "789"})
    @ParameterizedTest
    void constructGameNumberWithCorrectInput(String input) {
        GameNumber a = GameNumber.of(input);
        for (GameDigit b : a.getGameNumber()) {
            System.out.println(System.identityHashCode(b));
        }
        assertThat(GameNumber.of(input)).isInstanceOf(GameNumber.class);
    }

}