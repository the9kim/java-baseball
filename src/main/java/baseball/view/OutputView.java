package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public static void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printRequestNumber(){
        String input = Console.readLine();
    }
}
