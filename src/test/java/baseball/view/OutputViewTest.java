package baseball.view;

import baseball.domain.Ball;
import baseball.domain.Nothing;
import baseball.domain.Result;
import baseball.domain.Strike;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @DisplayName("결과 출력 테스트 - 낫싱")
    @Test
    void printResultNothing() {
        Result result = Result.of(Strike.of(0), Ball.of(0), Nothing.of(true));

        OutputView.printCountResult(result);
    }

    @DisplayName("결과 출력 테스트")
    @Test
    void printResultStrikeOnly() {
        Result result = Result.of(Strike.of(2), Ball.of(0), Nothing.of(false));

        OutputView.printCountResult(result);
    }

    @DisplayName("결과 출력 테스트 - 볼")
    @Test
    void printResultBallOnly() {
        Result result = Result.of(Strike.of(0), Ball.of(2), Nothing.of(false));

        OutputView.printCountResult(result);
    }

    @DisplayName("결과 출력 테스트 - 볼 & 스트라이크")
    @Test
    void printResultStrikeAndBall() {
        Result result = Result.of(Strike.of(1), Ball.of(1), Nothing.of(false));

        OutputView.printCountResult(result);
    }

}