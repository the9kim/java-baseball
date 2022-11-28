package baseball.domain;

public class Nothing {
    private boolean nothingCount;

    public void updateNothing(boolean nothingCount) {
        this.nothingCount = nothingCount;
    }

    public boolean checkNothing() {
        return nothingCount;
    }

}
