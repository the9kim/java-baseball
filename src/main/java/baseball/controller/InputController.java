package baseball.controller;

import baseball.domain.Player;
import baseball.view.InputView;

public class InputController {

    public Player makePlayerNumber() {
        while (true) {
            try {
                String playerNumber = InputView.readPlayerNumber();
                Player player = Player.of(playerNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
