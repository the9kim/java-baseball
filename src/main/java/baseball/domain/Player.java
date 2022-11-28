package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    List<GameNumber> playerGameNumbers = new ArrayList<>();

    public List<GameNumber> makePlayerNumbers(String inputNumber) {
       List<String> splitNumber = splitInputNumber(inputNumber);
       getNumbers(splitNumber);
       return playerGameNumbers;
    }

    private List<String> splitInputNumber(String inputNumber) {
        String[] splitNumbers = inputNumber.split("");
        return Arrays.asList(splitNumbers);
    }

    private void getNumbers(List<String> splitNumbers) {
        for (String eachNumber : splitNumbers) {
            GameNumber gameNumber = makeNumber(eachNumber);
            if (!validateDuplication(gameNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복 숫자는 입력할 수 없다 짜샤");
            }
            playerGameNumbers.add(gameNumber);
        }
    }

    private boolean validateDuplication(GameNumber gameNumber) {
        for (GameNumber eachGameNumber : playerGameNumbers) {
            if (eachGameNumber.getNumber() == gameNumber.getNumber()) {
                return false;
            }
        }
        return true;
    }

    private GameNumber makeNumber(String eachNumber) {
        GameNumber gameNumber = new GameNumber(eachNumber);
        return gameNumber;
    }

    public List<GameNumber> getPlayerNumbers() {
        return playerGameNumbers;
    }
}
