package baseball.domain;

import baseball.util.BaseBallValues;
import nextstep.utils.Randoms;

public class ComNumber extends Number {

    private static int overlapFlag;
    private static int index;

    public ComNumber(int[] numbers) {
        super(numbers);
        validateNumber("컴퓨터");
        index = -1;
        overlapFlag = 0;
        createRandomComNumber();
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
        return (overlapFlag ^ super.numbers[index]) != overlapFlag;
    }
}
