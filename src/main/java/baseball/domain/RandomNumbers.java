package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final int MAX_SIZE_OF_NUMBERS = 3;
    private List<Integer> tempRandomNumber = new ArrayList<>();
    private final List<GameNumber> randomGameNumbers = new ArrayList<>();

    public List<GameNumber> makeRandomNumbers() {
        int sizeOfNumber = 0;
        while (sizeOfNumber < MAX_SIZE_OF_NUMBERS) {
            sizeOfNumber += makeGameNumber();
        }
        return randomGameNumbers;
    }

    private int makeGameNumber() {
        int randomNumber = createRandomNumber();
        if (!validateDuplication(randomNumber)) {
            return 0;
        }
        GameNumber gameNumber = new GameNumber(randomNumber);
        randomGameNumbers.add(gameNumber);
        return 1;
    }

    private int createRandomNumber() {
        int randomNumber = (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
        return randomNumber;
    }

    private boolean validateDuplication(int number) {
        if (tempRandomNumber.contains(number)) {
            return false;
        }
        tempRandomNumber.add(number);
        return true;
    }

    public List<GameNumber> getRandomNumbers() {
        return randomGameNumbers;
    }
}
