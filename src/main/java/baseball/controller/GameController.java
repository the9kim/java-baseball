package baseball.controller;

import baseball.domain.ComputerNumberMaker;
import baseball.domain.Player;
import baseball.domain.RandomNumberGenerator;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        List<Integer> computerNumber = generateComputerNumber();
        System.out.println(computerNumber);
        Player player = playGame();

    }

    private List<Integer> generateComputerNumber() {
        ComputerNumberMaker computerNumberMaker = new ComputerNumberMaker(new RandomNumberGenerator());
        List<Integer> computerNumber = computerNumberMaker.makeNumbers();
        return computerNumber;
    }

    private Player playGame() {
        Player player = inputController.makePlayerNumber();
    }
}
