package baseball.domain;

import baseball.view.InputView;

public class Ball {
    int count;

    public void updateBallCount(int count) {
        this.count = count;
    }

    public int getBallCount() {
        return count;
    }
}
