package baseball.domain;

import java.util.List;

public class Judge {
    private final Result result = new Result();
    private static final int MAX_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    public Result judgeGame(List<GameNumber> randomNumbers, List<GameNumber> playerNumbers) {
        getStrikeCount(randomNumbers, playerNumbers);
        getBallCount(randomNumbers, playerNumbers);
        result.updateResult(strikeCount, ballCount);
        return result;
    }

    private void getStrikeCount(List<GameNumber> randomNumbers, List<GameNumber> playerNumbers) {
        for (int i = 0; i < MAX_COUNT; i++) {
            if (randomNumbers.get(i).getNumber() == playerNumbers.get(i).getNumber()) {
                strikeCount++;
            }
        }
    }

    private void getBallCount(List<GameNumber> randomNumbers, List<GameNumber> playerNumbers) {
        for (GameNumber playerNum : playerNumbers) {
            if (findNumber(randomNumbers, playerNum.getNumber())
                    && getIndex(randomNumbers, playerNum.getNumber()) != playerNumbers.indexOf(playerNum)) {
                ballCount++;
            }
        }
    }

    private boolean findNumber(List<GameNumber> randomNumbers, int number) {
        for (GameNumber randomNumber : randomNumbers) {
            if (randomNumber.getNumber() == number) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(List<GameNumber> randomNumbers, int number) {
        for (GameNumber randomGameNumber : randomNumbers) {
            if (randomGameNumber.getNumber() == number) {
                return randomNumbers.indexOf(randomGameNumber);
            }
        }
        return -1;
    }
}
