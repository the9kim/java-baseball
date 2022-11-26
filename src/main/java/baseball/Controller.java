package baseball;

import java.util.List;

import baseball.domain.Player;
import baseball.domain.RandomNumbers;
import baseball.view.InputView;

public class Controller {

    public void run() {
        RandomNumbers randomNumbers = getRandomNumbers();
        Player player = getPlayerNumber();
    }

    private RandomNumbers getRandomNumbers() {
        RandomNumbers randomNumbers = new RandomNumbers();
        return randomNumbers;
    }

    private Player getPlayerNumber() {
        String playerInput = InputView.readPlayerNumber();
        Player player = new Player(playerInput);
        return player;
    }

}
