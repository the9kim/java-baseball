package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.awt.desktop.SystemEventListener;

public class InputView {

    public static String readInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String inputNumber = Console.readLine();
        return inputNumber;
    }

    public static String readRetryDecision() {
        System.out.println("재시작 또는 종료 여부를 선택해주세요(1: 재시작, 2: 종료)");
        String input = Console.readLine();
        return input;
    }
}
