package baseball.domain;

public class Strike {

    private final int count;

    private Strike(int count) {
        this.count = count;
    }

    public static Strike of(int count) {
        return new Strike(count);
    }

    public int getCount() {
        return count;
    }
}
