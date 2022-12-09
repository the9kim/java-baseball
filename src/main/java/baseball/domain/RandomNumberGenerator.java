package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int generate() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber;
    }
}
