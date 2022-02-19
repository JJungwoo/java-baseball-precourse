package baseball.domain;

public class UserNumber extends Number {

    public UserNumber(String numberStr) {
        super(convertNumberStrToIntArray(numberStr));
        validateNumber("유저");
    }

    private static int[] convertNumberStrToIntArray(String numberStr) {
        int[] numbers = new int[NUMBER_LENGTH];
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numbers[i] = (int) numberStr.charAt(i);
        }
        return numbers;
    }
}
