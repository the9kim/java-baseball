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
        if (gameNumber.size() != numberSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public Result compareNumbers(GameNumber playerNumber) {
        Strike strikeCount = countStrike(playerNumber);
        Ball ballCount = countBall(playerNumber);
        Nothing nothing = checkNothing(playerNumber);
        return Result.of(strikeCount, ballCount, nothing);
    }

    private Strike countStrike(GameNumber playerNumber) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (gameNumber.get(i).equals(playerNumber.getGameNumber().get(i))) {
                strikeCount++;
            }
        }
        return Strike.of(strikeCount);
    }

    private Ball countBall(GameNumber playerNumber) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (gameNumber.contains(playerNumber.getGameNumber().get(i))
                    && !gameNumber.get(i).equals(playerNumber.gameNumber.get(i))) {
                ballCount++;
            }
        }
        return Ball.of(ballCount);
    }

    private Nothing checkNothing(GameNumber playerNumber) {
        boolean nothing = false;
        Set<GameDigit> common = new HashSet<>(gameNumber);
        common.retainAll(playerNumber.getGameNumber());
        if (common.size() == 0) {
            nothing = true;
        }
        return Nothing.of(nothing);
    }

    public List<GameDigit> getGameNumber() {
        return gameNumber;
    }

}
