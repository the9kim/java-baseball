package baseball.controller;

import baseball.domain.GameDigit;
import baseball.domain.GameNumber;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Result;
import baseball.view.OutputView;

public class GameController {

    InputController inputController;

    public void run() {
        do {
            GameNumber randomGameNumber = RandomNumberGenerator.generateRandomNumbers();
            for (GameDigit a : randomGameNumber.getGameNumber()) {
                System.out.print(a.getDigit());
            }
            playGame(randomGameNumber);
        } while (InputController.getRetryDecision());
    }

    private void playGame(GameNumber randomGameNumber) {
        Boolean answer;
        do {
            GameNumber playerNumber = inputController.getPlayerNumber();
            Result result = randomGameNumber.compareNumbers(playerNumber);
            OutputView.printCountResult(result);

            answer = result.getAnswer();
        } while (!answer);
    }
}
