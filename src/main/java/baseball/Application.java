package baseball;

import baseball.controller.GameController;
import baseball.domain.GameNumber;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}
