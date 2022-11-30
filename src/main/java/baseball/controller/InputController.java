package baseball.controller;

import baseball.domain.GameNumber;
import baseball.view.InputView;

public class InputController {

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
                return RetryOption.of(InputView.readRetryDecision()).isRetryDecision();
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }


}
