package baseball.domain;

import baseball.util.BaseBallValues;
import nextstep.utils.Randoms;

public class ComNumber extends Number {

    private boolean[] checkMap = new boolean[BaseBallValues.END_NUMBER + 1];
    private static int index;

    public ComNumber(int[] numbers) {
        super(numbers);
        index = -1;
        createRandomComNumber();
        validateNumber("컴퓨터");
    }

    private void createRandomComNumber() {
        if (++index >= BaseBallValues.NUMBER_LENGTH) {
            return;
        }

        super.numbers[index] = Randoms.pickNumberInRange(
                BaseBallValues.BEGIN_NUMBER, BaseBallValues.END_NUMBER);
        if (checkOverlapNumber()) {
            index--;
        }
        createRandomComNumber();
    }

    // 리턴 true 일 때 값 중복
    private boolean checkOverlapNumber() {
        if (checkMap[super.numbers[index]]) {
            return true;
        }
        checkMap[super.numbers[index]] = true;
        return false;
    }
}
