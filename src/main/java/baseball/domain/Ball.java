package baseball.domain;

public class Ball {

    private final int count;

    private Ball(int count) {
        this.count = count;
    }

    public static Ball of(int count) {
        Ball ball = new Ball(count);
        return ball;
    }

    public int getCount() {
        return count;
    }

}
