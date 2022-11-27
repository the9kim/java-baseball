package baseball.domain;

import java.util.List;

public class Judge {
    private final Result result = new Result();
    private int strikeCount;
    private int ballCount;

    public Result judgeGame(RandomNumbers randomNumbers, Player player) {
        getStrikeCount(randomNumbers, player);
        getBallCount(randomNumbers, player);
        result.updateResult(strikeCount, ballCount);
        return result;
    }

    private void getStrikeCount(RandomNumbers randomNumbers, Player player) {
        List<Number> playerNumList = player.getPlayerNumbers();
        for (Number playerNum : playerNumList) {
            if (randomNumbers.findNumber(playerNum.getNumber())
                    && randomNumbers.getIndex(playerNum.getNumber()) == playerNumList.indexOf(playerNum)) {
                strikeCount++;
            }
        }
    }

    private void getBallCount(RandomNumbers randomNumbers, Player player) {
        List<Number> playerNumList = player.getPlayerNumbers();
        for (Number playerNum : playerNumList) {
            if (randomNumbers.findNumber(playerNum.getNumber())
                    && randomNumbers.getIndex(playerNum.getNumber()) != playerNumList.indexOf(playerNum)) {
                ballCount++;
            }
        }
    }
}
