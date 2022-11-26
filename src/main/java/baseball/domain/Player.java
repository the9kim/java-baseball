package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    List<Number> playerNumbers = new ArrayList<>();

    public Player(String inputNumber) {
       List<String> splitNumber = splitInputNumber(inputNumber);
       getNumbers(splitNumber);
    }

    private List<String> splitInputNumber(String inputNumber) {
        String[] splitNumbers = inputNumber.split("");
        return Arrays.asList(splitNumbers);
    }

    private void getNumbers(List<String> splitNumbers) {
        for (String eachNumber : splitNumbers) {
            Number number = makeNumber(eachNumber);
            if (!validateDuplication(number)) {
                throw new IllegalArgumentException("[ERROR] 중복 숫자는 입력할 수 없다 짜샤");
            }
            playerNumbers.add(number);
        }
    }

    private boolean validateDuplication(Number number) {
        for (Number eachNumber : playerNumbers) {
            if (eachNumber.getNumber() == number.getNumber()) {
                return false;
            }
        }
        return true;
    }

    private Number makeNumber(String eachNumber) {
        Number number = new Number(eachNumber);
        return number;
    }

    public List<Number> getPlayerNumbers() {
        return playerNumbers;
    }
}
