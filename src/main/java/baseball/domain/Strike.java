package baseball.domain;

public class Strike {
    private static final int DEFAULT_COUNT = 0;
    private int count;

    public void updateStrikeCount(int count) {
        this.count = count;
    }

    public int getStrikeCount() {
        return count;
    }
}
