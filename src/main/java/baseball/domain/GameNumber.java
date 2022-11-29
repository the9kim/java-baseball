package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {

    private List<GameDigit> gameNumber = new ArrayList<>();


    public static GameNumber of(List<Integer> randomNumbers) {
        GameNumber randomGameNumber = new GameNumber();
        for (Integer number : randomNumbers) {
            randomGameNumber.gameNumber.add(GameDigit.of(number));
        }
        return randomGameNumber;
    }

    public List<GameDigit> getGameNumber() {
        return gameNumber;
    }

}
