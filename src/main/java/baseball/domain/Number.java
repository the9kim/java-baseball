package baseball.domain;

public class Number {

    int number;

    public Number(int number) {
        validateNumber(number);
        this.number = number;

    }

    private void validateNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("[ERROR] 1부터 9까지 숫자를 입력하세요.");
        }
    }

    public int getNumber() {
        return number;
    }
}
