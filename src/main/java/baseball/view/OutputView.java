package baseball.view;

import baseball.domain.Result;

public class OutputView {

    private static final String BALL_COMMENT = "볼";
    private static final String STRIKE_COMMENT = "스트라이크";
    private static final String NOTHING_COMMENT = "낫싱";
    private static final String BLANK = " ";

    public static void printCountResult(Result result) {
        StringBuilder stringBuilder = new StringBuilder();
        appendBall(stringBuilder, result);
        appendStrike(stringBuilder, result);
        appendNothing(stringBuilder, result);
        System.out.println(stringBuilder);
    }

    private static void appendBall(StringBuilder stringBuilder, Result result) {
        if (result.getBall().getCount() > 0) {
            stringBuilder.append(result.getBall().getCount());
            stringBuilder.append(BALL_COMMENT);
            stringBuilder.append(BLANK);
        }
    }

    private static void appendStrike(StringBuilder stringBuilder, Result result) {
        if (result.getStrike().getCount() > 0) {
            stringBuilder.append(result.getStrike().getCount());
            stringBuilder.append(STRIKE_COMMENT);
        }
    }

    private static void appendNothing(StringBuilder stringBuilder, Result result) {
        if (w
            stringBuilder.append(NOTHING_COMMENT);
        }
    }
}
