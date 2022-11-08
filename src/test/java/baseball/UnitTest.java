package baseball;

import baseball.domain.ComputerNumber;
import baseball.service.JudgeGame;
import baseball.util.ValidationUtil;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class UnitTest extends NsTest {

    @Test
    void 세자리_수_입력값_적정성_검토() {

        String examNum1 = "1234";
        String examNum2 = "110";
        String examNum3 = "ktx";
        String examNum4 = "112";

        boolean return1 = ValidationUtil.validateInputNumber(examNum1);
        boolean return2 = ValidationUtil.validateInputNumber(examNum2);
        boolean return3 = ValidationUtil.validateInputNumber(examNum3);
        boolean return4 = ValidationUtil.validateInputNumber(examNum4);

        assertThat(return1).isEqualTo(false);
        assertThat(return2).isEqualTo(false);
        assertThat(return3).isEqualTo(false);
        assertThat(return4).isEqualTo(false);
    }

    void 세자리_수_입력값_적정성_검토_후_리스트_변환(){

        String inputNum = "123";
        List<String> answerList = new ArrayList<>();
        answerList.add("1");
        answerList.add("2");
        answerList.add("3");

        if (ValidationUtil.validateInputNumber(inputNum)){
            List<String> inputNumList = new ArrayList<>();
            inputNumList = JudgeGame.getInputNumberList(inputNum);
            assertThat(inputNumList).isEqualTo(answerList);
        }
    }

    void 컴퓨터_생성_세자리_난수_적정성_검토(){
        ComputerNumber computerNumber = new ComputerNumber();
        Integer hundredNumber = computerNumber.computerNumberList.get(0);
        Integer tenNumber = computerNumber.computerNumberList.get(0);
        Integer number = computerNumber.computerNumberList.get(0);

        assertThat(hundredNumber).isBetween(1, 9);
        assertThat(tenNumber).isBetween(1, 9);
        assertThat(number).isBetween(1,9);
        assertThat(hundredNumber).isNotEqualTo(tenNumber);
        assertThat(hundredNumber).isNotEqualTo(number);
        assertThat(tenNumber).isNotEqualTo(number);
    }

    @Test
    void 스트라이크_및_볼_개수_출력값_검증(){
        List<Integer> inputNumList = new ArrayList<>();
        List<Integer> computerNumList = new ArrayList<>();

        inputNumList.add(3);
        inputNumList.add(6);
        inputNumList.add(9);

        computerNumList.add(9);
        computerNumList.add(6);
        computerNumList.add(3);

        int strikeCounter = JudgeGame.verifyStrike(inputNumList, computerNumList);
        int ballCounter = JudgeGame.verifyBall(inputNumList, computerNumList);

        assertThat(strikeCounter).isEqualTo(1);
        assertThat(ballCounter).isEqualTo(2);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}