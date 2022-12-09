package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readPlayerNumber() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.printf("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        isBlank(input);
        isDigit(input);
        return input;
    }

    public static String readGameCommand() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input;
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다");
        }
    }

    private static void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 정수가 아닙니다");
            }
        }
    }
}
