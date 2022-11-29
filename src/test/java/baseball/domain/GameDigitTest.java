package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class GameDigitTest {

    @DisplayName("정적 팩토리 메서드를 이용하면 입력 정수에 맞는 GameDigit 객체가 생성된다")
    @Test
    void constructGameDigit() {
        int digit = 3;

        GameDigit gameDigit = GameDigit.of(digit);

        assertThat(gameDigit.getDigit()).isEqualTo(digit);
    }

}