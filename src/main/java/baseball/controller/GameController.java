package baseball.controller;

import baseball.domain.*;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        do {
            List<Integer> computerNumber = generateComputerNumber();
            playGame(computerNumber);
        } while (inputController.checkRetry());
    }

    private List<Integer> generateComputerNumber() {
        ComputerNumberMaker computerNumberMaker = new ComputerNumberMaker(new RandomNumberGenerator());
        List<Integer> computerNumber = computerNumberMaker.makeNumbers();
        return computerNumber;
    }

    private void playGame(List<Integer> computerNumber) {
        do {
            Player player = inputController.makePlayerNumber();
            Judge.getCount(computerNumber, player.getPlayerNumbers());
            OutputView.printResult();
        } while (!Judge.checkStrikes());
    }
}
