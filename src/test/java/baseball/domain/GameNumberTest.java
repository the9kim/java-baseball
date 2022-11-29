package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberTest {

    @DisplayName("GameNumber 정적 팩토리 메서드의 메개변수로 List<Integer> 타입의 값을 입력하면 GameNumber 객체가 생성된다")
    @Test
    void constructGameNumber() {
        List<Integer> randomNumbers = List.of(1,2,3);

        GameNumber gameNumber = GameNumber.of(randomNumbers);

        for (GameDigit digit : gameNumber.getGameNumber()) {
            System.out.println(digit.getDigit());
            assertThat(digit.getDigit()).isBetween(1,3);
        }

    }

}