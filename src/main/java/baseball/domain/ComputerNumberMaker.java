package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberMaker {

    private static final int NUMBER_SIZE = 3;
    private List<Integer> randomNumbers = new ArrayList<>();
    NumberGenerator numberGenerator;

    public ComputerNumberMaker(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> makeNumbers() {
        List<Integer> randomNumbers;
        do {
            randomNumbers = generateNumbers();
        } while (!validateDuplication(randomNumbers));
        return randomNumbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i=0; i<NUMBER_SIZE;i++) {
            randomNumbers.add(numberGenerator.generate());
        }
        return randomNumbers;
    }

    private boolean validateDuplication(List<Integer> randomNumbers) {
        for (int i=0; i<randomNumbers.size()-1; i++) {
            if (randomNumbers.subList(i + 1, NUMBER_SIZE).contains(randomNumbers.get(i))) {
                return false;
            }
        }
        return true;
    }
}
