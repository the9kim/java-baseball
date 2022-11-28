package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import baseball.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }


    @DisplayName("스트라이크 카운트만 있을 경우 결과가 정상 출력된다")
    @Test
    void printStrikeCountOnly() {

        result.updateResult(3, 0, false);

        OutputView.printGameResult(result);
    }

    @DisplayName("볼 카운트만 있을 경우 결과가 정상 출력된다.")
    @Test
    void printBallCountOnly() {

        result.updateResult(0, 2, false);

        OutputView.printGameResult(result);
    }

    @DisplayName("스트라이크와 볼 카운트 모두 있을 경우 결과가 정상 출력된다.")
    @Test
    void printStrikeAndBallCount() {

        result.updateResult(1, 2, false);

        OutputView.printGameResult(result);
    }

    @DisplayName("스트라이크와 볼 카운트 모두 없을 경우 결과가 정상 출력된다.")
    @Test
    void printNotingCount() {

        result.updateResult(0, 0, true);

        OutputView.printGameResult(result);
    }
}