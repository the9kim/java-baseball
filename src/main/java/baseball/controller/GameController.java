package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.RandomNumberGenerator;

public class GameController {

    InputController inputController;

    public void run() {
            GameNumber randomGameNumber = RandomNumberGenerator.generateRandomNumbers();
            playGame(randomGameNumber);
    }

    private void playGame(GameNumber randomGameNumber) {
        GameNumber playerNumber = inputController.getPlayerNumber();
    }
}
