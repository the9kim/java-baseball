package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("노 스트라이크, 노 볼일 경우 Nothing 객체의 필드값은 true가 된다")
    @Test
    void updateNothingResult() {
        int strikeCount = 0;
        int ballCount = 0;

        Result result = new Result();
        result.updateResult(strikeCount, ballCount);

        assertThat(result.getNothing().checkNothing()).isTrue();
    }

    @DisplayName(" 1스트라이크, 1볼의 경우 스트라이크 객체 및 볼 객체의 필드값은 각각 1이다")
    @Test
    void updateResult() {
        int strikeCount = 1;
        int ballCount = 1;

        Result result = new Result();
        result.updateResult(strikeCount, ballCount);

        assertThat(result.getStrike().getStrikeCount()).isEqualTo(1);
        assertThat(result.getBall().getBallCount()).isEqualTo(1);
    }
}