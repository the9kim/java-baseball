package baseball.domain;

import net.bytebuddy.asm.Advice;

public class Number {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void validateNumber(String inputNumber) {
        if (isBlank(inputNumber) || !validateDigit(inputNumber)
                || !validateRange(inputNumber)) {
            throw new IllegalArgumentException("1부터 9까지 숫자를 입력해라 임마.");
        }
    }

    private boolean isBlank(String inputNumber) {
        return inputNumber.isBlank();
    }

    private boolean validateDigit(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            char eachNumber = inputNumber.charAt(i);
            if (!Character.isDigit(eachNumber)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRange(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            return false;
        }
        return true;
    }

    public int getNumber() {
        return number;
    }
}
