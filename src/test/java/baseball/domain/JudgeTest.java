package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    RandomNumbers randomNum = new RandomNumbers();
    List<GameNumber> randomNumbers = randomNum.makeRandomNumbers();
    Player player = new Player();
    List<GameNumber> playerNumbers = player.makePlayerNumbers("247");
    Judge judge = new Judge();

    @DisplayName("RandomNumber와 Player 넘버를 비교하면 스트라이크와 볼의 개수는 각각 0-3의 범위에 포함된다.")
    @Test
    void judgeGame() {

        Result result = judge.judgeGame(randomNumbers, playerNumbers);

        assertThat(result.getStrike().getStrikeCount()).isBetween(0, 3);
        assertThat(result.getBall().getBallCount()).isBetween(0, 3);

    }
}