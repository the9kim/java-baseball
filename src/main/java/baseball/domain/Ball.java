package baseball.domain;

public class Ball {
    private static final int DEFAULT_COUNT = 0;
    private int count;

    public void updateBallCount(int count) {
        this.count = count;
    }

    public int getBallCount() {
        return count;
    }

}
