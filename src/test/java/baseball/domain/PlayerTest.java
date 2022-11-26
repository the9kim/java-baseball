package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("플레이어가 중복 숫자를 입력하면 오류가 발생한다")
    @Test
    void makePlayerWithWrongInput() {
        String inputNumber = "556";

        assertThatThrownBy(() -> {
            new Player(inputNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 다른 세자리 숫자를 문자열 타입 매개변수로 사용하면 Player 객체가 정상적으로 생성된다")
    @Test
    void makePlayerWithCorrectInput() {
        String input = "247";

        Player player = new Player(input);

        for(Number eachNum : player.getPlayerNumbers()) {
            System.out.println(eachNum.getNumber());
        }
        assertThat(player.getPlayerNumbers().size()).isEqualTo(3);
    }
}