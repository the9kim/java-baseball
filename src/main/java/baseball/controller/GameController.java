package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Result;
import baseball.view.OutputView;

public class GameController {

    InputController inputController;

    public void run() {
            GameNumber randomGameNumber = RandomNumberGenerator.generateRandomNumbers();
            playGame(randomGameNumber);
    }

    private void playGame(GameNumber randomGameNumber) {
        GameNumber playerNumber = inputController.getPlayerNumber();
        Result result = randomGameNumber.compareNumbers(playerNumber);
        OutputView.printCountResult(result);
    }
}
