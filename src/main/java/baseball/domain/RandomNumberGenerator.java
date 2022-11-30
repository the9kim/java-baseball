package baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int NUMBER_SIZE = 3;

    private static List<Integer> randomNumbers;

    public static GameNumber generateRandomNumbers() {
        setRandomNumbers();
        shuffleRandomNumbers();
        pickRandomNumbers();

        return GameNumber.of(randomNumbers);
    }


    private static void setRandomNumbers() {
        randomNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void shuffleRandomNumbers() {
        Collections.shuffle(randomNumbers);
    }

    private static void pickRandomNumbers() {
        randomNumbers = randomNumbers.subList(0, NUMBER_SIZE);
    }


}
