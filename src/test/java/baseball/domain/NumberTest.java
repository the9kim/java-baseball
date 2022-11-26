package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("매개값을 0으로 하여 Number 객체를 생성하면 오류가 발생한다.")
    @ValueSource(ints = {0, 10})
    @ParameterizedTest
    void makeNumber(int input) {

        assertThatThrownBy(() -> {
            new Number(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}