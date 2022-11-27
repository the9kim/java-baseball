package baseball.domain;

public class Result {
    private final Strike strike = new Strike();
    private final Ball ball = new Ball();
    private final Nothing nothing = new Nothing();

    public void updateResult(int strikeCount, int ballCount) {
        strike.updateStrikeCount(strikeCount);
        ball.updateBallCount(ballCount);
        if (strikeCount == 0 && ballCount == 0) {
            nothing.updateNothing();
        }
    }

    public Strike getStrike() {
        return strike;
    }

    public Ball getBall() {
        return ball;
    }

    public Nothing getNothing() {
        return nothing;
    }

    public boolean checkAnswer() {
        if (strike.getStrikeCount() == 3) {
            return true;
        }
        return false;
    }

}
