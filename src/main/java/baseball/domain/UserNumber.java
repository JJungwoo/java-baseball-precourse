package baseball.domain;

import baseball.util.BaseBallValues;

public class UserNumber extends Number {

    public UserNumber(String numberStr) {
        super(convertNumberStrToIntArray(numberStr));
        validateNumber("유저");
    }

    private static int[] convertNumberStrToIntArray(String numberStr) {
        int[] numbers = new int[BaseBallValues.NUMBER_LENGTH];
        for (int i = 0; i < BaseBallValues.NUMBER_LENGTH; i++) {
            numbers[i] = numberStr.charAt(i) - '0';
        }
        return numbers;
    }
}
