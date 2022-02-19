package baseball.domain;

import baseball.util.BaseBallValues;

public abstract class Number {

    protected int[] numbers;

    public Number(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    protected void validateNumber(String target) {
        if (numbers.length > BaseBallValues.NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] " + target + " 값이 너무 많습니다.");
        }

        if (numbers.length < BaseBallValues.NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] " + target + " 값이 너무 적습니다.");
        }

        if (numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[0] == numbers[2]) {
            throw new IllegalArgumentException("[ERROR] " + target + " 값이 중복되었습니다.");
        }
    }

}
