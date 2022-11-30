package baseball.controller;

import baseball.domain.GameNumber;
import baseball.view.InputView;

public class InputController {

    private static final String RETRY_DECISION = "1";
    private static final String END_DECISION = "2";

    public static GameNumber getPlayerNumber() {
        while (true) {
            try {
                return GameNumber.of(InputView.readInputNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean getRetryDecision() {
        while (true) {
            try {
                return isRetrial(validate(InputView.readRetryDecision()));
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    private static String validate(String input) {
        if (!input.equals(RETRY_DECISION) && !input.equals(END_DECISION)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2가 아닙니다");
        }
        return input;
    }

    private static boolean isRetrial(String input) {
        if (input.equals("1")) {
            return true;
        }
        return false;
    }


}
