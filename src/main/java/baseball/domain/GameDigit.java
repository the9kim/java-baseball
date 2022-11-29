package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class GameDigit {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int digit;

    private static Map<Integer, GameDigit> gameDigitCache = new HashMap<>();

    static {
        for (int digit = MIN_NUMBER; digit <= MAX_NUMBER; digit++) {
            gameDigitCache.put(digit, new GameDigit(digit));
        }
    }

    private GameDigit(int digit) {
        this.digit = digit;
    }

    public static GameDigit of(int digit) {
        return gameDigitCache.get(digit);
    }

    public int getDigit() {
        return digit;
    }
}
