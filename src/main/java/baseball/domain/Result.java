package baseball.domain;

public class Result {

    private final Strike strike;
    private final Ball ball;
    private final Nothing nothing;

    private Result(Strike strike, Ball ball, Nothing nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public static Result of(Strike strike, Ball ball, Nothing nothing) {
        return new Result(strike, ball, nothing);
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
}
