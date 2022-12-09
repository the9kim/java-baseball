package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputController());
        gameController.run();
    }
}
