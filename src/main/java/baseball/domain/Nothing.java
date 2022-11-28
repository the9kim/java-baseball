package baseball.domain;

public class Nothing {
    private static final boolean DEFAULT_COUNT = false;
    private boolean nothingCount;

    public void updateNothing(boolean nothingCount) {
        this.nothingCount = nothingCount;
    }

    public boolean checkNothing() {
        return nothingCount;
    }

}
