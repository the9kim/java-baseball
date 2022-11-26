package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final int MAX_SIZE_OF_NUMBERS = 3;
    private List<Integer> tempRandomNumber = new ArrayList<>();
    private final List<Number> randomNumbers = new ArrayList<>();

    public RandomNumbers() {
        makeRandomNumbers();
        }

    public void makeRandomNumbers() {
        int sizeOfNumber = 0;

        while (sizeOfNumber < MAX_SIZE_OF_NUMBERS) {
            int randomNumber = createRandomNumber();
            if (!validateDuplication(randomNumber)) {
                continue;
            }
            tempRandomNumber.add(randomNumber);
            Number number = new Number(randomNumber);
            randomNumbers.add(number);
            sizeOfNumber++;
        }
    }

    private int createRandomNumber() {
        int randomNumber = (int) ((Math.random()*(MAX_NUMBER-MIN_NUMBER))+MIN_NUMBER);
        return randomNumber;
    }

    private boolean validateDuplication(int number) {
        if (tempRandomNumber.contains(number)) {
            return false;
        }
        return true;
    }

    public List<Number> getRandomNumbers() {
        return randomNumbers;
    }
}
