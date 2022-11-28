package baseball.domain;

public class Strike {
    private int count;

    public void updateStrikeCount(int count) {
        this.count = count;
    }

    public int getStrikeCount() {
        return count;
    }
}
