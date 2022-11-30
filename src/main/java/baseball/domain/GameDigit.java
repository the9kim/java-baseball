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

    public static GameDigit of(String inputDigit) {
        validate(inputDigit);
        int digit = Integer.parseInt(inputDigit);
        return gameDigitCache.get(digit);
    }

    private static void validate(String inputDigit) {
        validateBlank(inputDigit);
        validateDigit(inputDigit);
        validateRange(inputDigit);
    }

    private static void validateBlank(String inputDigit) {
        if (inputDigit.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateDigit(String inputDigit) {
        if (!Character.isDigit(inputDigit.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    private static void validateRange(String inputDigit) {
        int digit = Integer.parseInt(inputDigit);
        if (digit < MIN_NUMBER || digit > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1-9 범위의 숫자가 아닙니다.");
        }
    }

    public int getDigit() {
        return digit;
    }
}
