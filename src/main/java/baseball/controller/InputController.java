package baseball.controller;

import baseball.domain.Player;
import baseball.view.InputView;

public class InputController {

    private static final String RETRY_DECISION = "1";
    private static final String QUICK_DECISION = "2";

    public Player makePlayerNumber() {
        while (true) {
            try {
                String playerNumber = InputView.readPlayerNumber();
                return Player.of(playerNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean checkRetry() {
        while (true) {
            try {
                String retryCommand = InputView.readGameCommand();
                return isRetry(retryCommand);
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    private boolean isRetry(String retryCommand) {
        validateCommand(retryCommand);
        if (retryCommand.equals(RETRY_DECISION)) {
            return true;
        }
        return false;
    }

    private void validateCommand(String retryCommand) {
        if (!retryCommand.equals(RETRY_DECISION) && !retryCommand.equals(QUICK_DECISION)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q가 아닙니다.");
        }
    }
}
