package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.RandomNumberGenerator;

public class GameController {

    public static void run() {
            GameNumber randomGameNumber = RandomNumberGenerator.generateRandomNumbers();
            playGame(randomGameNumber);
    }

    private static void playGame(GameNumber randomGameNumber) {
    }
}
