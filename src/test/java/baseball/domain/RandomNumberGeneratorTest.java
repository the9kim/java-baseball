package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 넘버가 정상적으로 생성된다")
    @Test
    void generateRandomNumber() {
        GameNumber gameNumber;

        gameNumber = RandomNumberGenerator.generateRandomNumbers();

        for (GameDigit digit : gameNumber.getGameNumber()) {
            System.out.println(digit.getDigit());
            assertThat(digit.getDigit()).isBetween(1, 9);
        }
    }


}