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
            int randomNumber = createRandomNumber();
            if (!validateDuplication(randomNumber)) {
                continue;
            }
            tempRandomNumber.add(randomNumber);
            GameNumber gameNumber = new GameNumber(randomNumber);
            randomGameNumbers.add(gameNumber);
            sizeOfNumber++;
        }
        return randomGameNumbers;
    }

    private int createRandomNumber() {
        int randomNumber = (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
        return randomNumber;
    }

    private boolean validateDuplication(int number) {
        if (tempRandomNumber.contains(number)) {
            return false;
        }
        return true;
    }

    public List<GameNumber> getRandomNumbers() {
        return randomGameNumbers;
    }

    public boolean findNumber(int number) {
        for (GameNumber randomGameNumber : randomGameNumbers) {
            if (randomGameNumber.getNumber() == number) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(int number) {
        for (GameNumber randomGameNumber : randomGameNumbers) {
            if (randomGameNumber.getNumber() == number) {
                return randomGameNumbers.indexOf(randomGameNumber);
            }
        }
        return -1;
    }
}
