package baseball.view;

import baseball.domain.Result;

public class OutputView {

    private static final String STRIKE_COMMENT = "스트라이크";
    private static final String BALL_COMMENT = "볼";
    private static final String NOTHING_COMMENT = "낫싱";

    public static void printGameResult(Result result) {
        int strikeCount = result.getStrike().getStrikeCount();
        int ballCount = result.getBall().getBallCount();
        boolean nothingCount = result.getNothing().checkNothing();
        printStrikeOnly(strikeCount, ballCount);
        printBallOnly(strikeCount, ballCount);
        printStrikeAndBall(strikeCount, ballCount);
        printNothing(nothingCount);
    }

    private static void printStrikeOnly(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount == 0) {
            System.out.printf("%s" + STRIKE_COMMENT + "\n", strikeCount);
        }
    }

    private static void printBallOnly(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount > 0) {
            System.out.printf("%s" + BALL_COMMENT + "\n", ballCount);
        }
    }

    private static void printStrikeAndBall(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.printf("%s" + BALL_COMMENT + " %s" + STRIKE_COMMENT + "\n", ballCount, strikeCount);
        }
    }

    private static void printNothing(boolean nothingCount) {
        if (nothingCount) {
            System.out.println(NOTHING_COMMENT);
        }
    }
}
