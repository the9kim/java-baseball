package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Player {

    private List<GameNumber> playerGameNumbers;

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
        playerGameNumbers = new ArrayList<>();
        for (String eachNumber : splitNumbers) {
            GameNumber gameNumber = makeNumber(eachNumber);
            playerGameNumbers.add(gameNumber);
        }
        if (!validatePlayerNumbers()) {
            throw new IllegalArgumentException();
        }

    }

    private boolean validatePlayerNumbers() {
        if (!validateDuplication() || !validateSize()) {
            return false;
        }
        return true;
    }

    private boolean validateDuplication() {
        return Set.copyOf(playerGameNumbers).size() == playerGameNumbers.size();
    }

    private boolean validateSize() {
        return playerGameNumbers.size() == 3;
    }


    private GameNumber makeNumber(String eachNumber) {
        GameNumber gameNumber = new GameNumber(eachNumber);
        return gameNumber;
    }

    public List<GameNumber> getPlayerNumbers() {
        return playerGameNumbers;
    }

}
