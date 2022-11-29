package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.RandomNumberGenerator;

public class GameController {

    public static void run() {
        GameNumber gameNumber = RandomNumberGenerator.generateRandomNumbers();

    }
}
