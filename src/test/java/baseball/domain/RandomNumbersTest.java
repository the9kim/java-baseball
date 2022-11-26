package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumbersTest {

    Number number;

    @DisplayName("랜덤 숫자 세자리가 정상적으로 출력된다")
    @Test
    void makeRandomNumbers() {
        RandomNumbers randomNumbers = new RandomNumbers();
        List<Number> randomNumList = randomNumbers.getRandomNumbers();
        for (Number number : randomNumList) {
            System.out.println(number.getNumber());
        }

        assertThat(randomNumbers.getRandomNumbers().size()).isEqualTo(3);
    }
}