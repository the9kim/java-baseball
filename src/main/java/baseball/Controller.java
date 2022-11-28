package baseball;

import java.util.List;

import baseball.domain.*;
import baseball.domain.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    RandomNumbers randomNumbers = new RandomNumbers();
    Player player = new Player();
    Judge judge = new Judge();

    public void run() {
        List<GameNumber> randomNumbers = getRandomNumbers();
        playGame(randomNumbers);
    }

    private List<GameNumber> getRandomNumbers() {
        List<GameNumber> randomGameNumberList = randomNumbers.makeRandomNumbers();
        return randomGameNumberList;
    }

    private void playGame(List<GameNumber> randomNumbers) {
        while (true) {
            List<GameNumber> playerNumbers = getPlayerNumber();
            Result result = getResult(randomNumbers, playerNumbers);
            if (!retry(result)) {
                break;
            }
        }
    }

    private List<GameNumber> getPlayerNumber() {
        String playerInput = InputView.readPlayerNumber();
        List<GameNumber> playerNumbers = player.makePlayerNumbers(playerInput);
        return playerNumbers;
    }

    private Result getResult(List<GameNumber> randomNumbers, List<GameNumber> playerNumbers) {
        Result result = judge.judgeGame(randomNumbers, playerNumbers);
        OutputView.printGameResult(result);
        return result;
    }

    private boolean retry(Result result) {
        if (result.checkAnswer()) {
            String retryInput = InputView.readRetryDecision();
            validateRetryInput(retryInput);
            checkRetryDecision(retryInput);
            return false;
        }
        return true;
    }

    private void validateRetryInput(String retryInput) {
        if (!retryInput.equals("1") && !retryInput.equals("2")) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2를 입력하세요.");
        }
    }

    private void checkRetryDecision(String retryInput) {
        if (retryInput.equals("1")) {
            run();
        }
    }
}
