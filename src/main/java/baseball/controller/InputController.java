package baseball.controller;

import baseball.domain.GameNumber;
import baseball.view.InputView;

public class InputController {

    public static GameNumber getPlayerNumber() {
        try {
            return GameNumber.of(InputView.readInputNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPlayerNumber();
            return null;
        }
    }
}
