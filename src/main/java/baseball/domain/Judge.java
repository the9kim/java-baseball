package baseball.domain;

import java.util.List;

public class Judge {

    private static final int NUMBER_SIZE = 3;
    private static int strikeCount;
    private static int ballCount;
    private static boolean nothing;

    public static void getCount(List<Integer> computerNumber, List<Integer> playerNumbers) {
        getStrikeCount(computerNumber, playerNumbers);
        getBallCount(computerNumber, playerNumbers);
        checkNothing(computerNumber, playerNumbers);
    }

    private static void getStrikeCount(List<Integer> computerNumber, List<Integer> playerNumbers) {
        strikeCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computerNumber.get(i) == playerNumbers.get(i)) {
                strikeCount++;
            }
        }
    }

    private static void getBallCount(List<Integer> computerNumber, List<Integer> playerNumbers) {
        ballCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computerNumber.get(i) != playerNumbers.get(i)
                    && computerNumber.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }
    }

    private static void checkNothing(List<Integer> computerNumber, List<Integer> playerNumbers) {
        nothing = false;
        for (Integer number : playerNumbers) {
            if (computerNumber.contains(number)) {
                nothing = false;
                return;
            }
        }
        nothing = true;
    }


    public static boolean checkStrikes() {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public static int getStrikeCount() {
        return strikeCount;
    }

    public static int getBallCount() {
        return ballCount;
    }

    public static boolean isNothing() {
        return nothing;
    }
}
