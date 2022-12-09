package baseball.view;

import baseball.domain.Judge;

public class OutputView {

    private static final String BALL_INDICATOR = "볼";
    private static final String STRIKE_INDICATOR = "스트라이크";
    private static final String NOTHING_INDICATOR = "낫싱";
    private static final String BLANK = " ";

    public static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(addBall());
        stringBuilder.append(addStrike());
        stringBuilder.append(addNothing());
        System.out.println(stringBuilder);
    }

    private static String addBall() {
        int ballCount = Judge.getBallCount();
        if (ballCount > 0) {
            return ballCount + BALL_INDICATOR + BLANK;
        }
        return "";
    }

    private static String addStrike() {
        int strikeCount = Judge.getStrikeCount();
        if (strikeCount > 0) {
            return strikeCount + STRIKE_INDICATOR;
        }
        return "";
    }

    private static String addNothing() {
        boolean isNothing = Judge.isNothing();
        if (isNothing == true) {
            return NOTHING_INDICATOR;
        }
        return "";
    }
}
