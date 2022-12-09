package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int NUMBER_SIZE = 3;
    private final List<Integer> playerNumbers;

    private Player(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public static Player of(String inputNumber) {
        List<Integer> playerNumbers = convertToList(inputNumber);
        validate(playerNumbers);
        return new Player(playerNumbers);
    }

    private static List<Integer> convertToList(String inputNumber) {
        List<Integer> playerNumbers = new ArrayList<>();
        String[] splitNumbers = inputNumber.split("");
        for (String number : splitNumbers) {
            playerNumbers.add(Integer.valueOf(number));
        }
        return playerNumbers;
    }

    private static void validate(List<Integer> playerNumbers) {
        validateSize(playerNumbers);
        validateRange(playerNumbers);
        validateDuplication(playerNumbers);
    }

    private static void validateSize(List<Integer> inputNumber) {
        if (inputNumber.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 세자리 정수가 아닙니다.");
        }
    }

    private static void validateRange(List<Integer> playerNumbers) {
        for (int number : playerNumbers) {
            if (number == 0) {
                throw new IllegalArgumentException("[ERROR] 숫자 0은 포함될 수 없습니다.");
            }
        }
    }

    private static void validateDuplication(List<Integer> playerNumbers) {
        for (int i = 0; i < playerNumbers.size() - 1; i++) {
            if (playerNumbers.subList(i + 1, NUMBER_SIZE).contains(playerNumbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
            }
        }
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
