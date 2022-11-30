package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumber {

    private static final int NUMBER_SIZE = 3;

    private final List<GameDigit> gameNumber;

    private GameNumber(List<GameDigit> gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static GameNumber of(List<Integer> randomNumbers) {
        List<GameDigit> playerNumber = new ArrayList<>();
        playerNumber.clear();
        for (Integer number : randomNumbers) {
            playerNumber.add(GameDigit.of(number));
        }
        return new GameNumber(playerNumber);
    }

    public static GameNumber of(String inputNumber) {
        List<GameDigit> playerNumber = new ArrayList<>();
        playerNumber.clear();
        String[] splitNumber = inputNumber.split("");
        for (String eachNumber : splitNumber) {
            playerNumber.add(GameDigit.of(eachNumber));
        }
        validate(playerNumber);
        return new GameNumber(playerNumber);
    }

    private static void validate(List<GameDigit> gameNumber) {
        validateSize(gameNumber);
        validateDuplication(gameNumber);
    }

    private static void validateSize(List<GameDigit> gameNumber) {
        if (gameNumber.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 세자리 숫자를 입력하세요.");
        }
    }

    private static void validateDuplication(List<GameDigit> gameNumber) {
        Set<GameDigit> numberSet = new HashSet<>(gameNumber);
        if (gameNumber.size() != numberSet.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public List<GameDigit> getGameNumber() {
        return gameNumber;
    }

}
