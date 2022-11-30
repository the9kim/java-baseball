package baseball.domain;

public class Result {

    private final Strike strike;
    private final Ball ball;
    private final Nothing nothing;
    private boolean answer;
    private static final int ANSWER_COUNT = 3;

    private Result(Strike strike, Ball ball, Nothing nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
        check3Strike(strike);
    }

    public static Result of(Strike strike, Ball ball, Nothing nothing) {
        return new Result(strike, ball, nothing);
    }

    private void check3Strike(Strike strike) {
        if (strike.getCount() == ANSWER_COUNT) {
            answer = true;
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

    public boolean getAnswer() {
        return answer;
    }
}
