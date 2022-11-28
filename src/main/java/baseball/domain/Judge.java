package baseball.domain;

import java.util.List;

public class Judge {
    private final Result result = new Result();
    private static final int MAX_COUNT = 3;

    public Result judgeGame(List<GameNumber> randomNumbers, List<GameNumber> playerNumbers) {
        int strikeCount = getStrikeCount(randomNumbers, playerNumbers);
        int ballCount = getBallCount(randomNumbers, playerNumbers);
        boolean nothingCount = getNothingCount(strikeCount, ballCount);
        result.updateResult(strikeCount, ballCount, nothingCount);
        return result;
    }

    private int getStrikeCount(List<GameNumber> randomNumbers, List<GameNumber> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < MAX_COUNT; i++) {
            if (randomNumbers.get(i).getNumber() == playerNumbers.get(i).getNumber()) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(List<GameNumber> randomNumbers, List<GameNumber> playerNumbers) {
        int ballCount = 0;
        for (GameNumber playerNum : playerNumbers) {
            if (findNumber(randomNumbers, playerNum.getNumber())
                    && getIndex(randomNumbers, playerNum.getNumber()) != playerNumbers.indexOf(playerNum)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean getNothingCount(int strikeCount, int ballCount) {
        boolean nothingCount = false;
        if (strikeCount == 0 && ballCount == 0) {
            nothingCount = true;
        }
        return nothingCount;
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
