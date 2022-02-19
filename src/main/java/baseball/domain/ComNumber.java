package baseball.domain;

import nextstep.utils.Randoms;

public class ComNumber extends Number {

    private static int overlapFlag;
    private static int index;

    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 1;

    public ComNumber(int[] numbers) {
        super(numbers);
        validateNumber("컴퓨터");
        index = -1;
        overlapFlag = 0;
        createRandomComNumber();
    }

    private void createRandomComNumber() {
        if (++index >= NUMBER_LENGTH) {
            return;
        }

        super.numbers[index] = Randoms.pickNumberInRange(BEGIN_NUMBER, END_NUMBER);
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
