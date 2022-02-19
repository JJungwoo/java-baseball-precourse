package baseball.service;

import baseball.domain.ComNumber;
import baseball.domain.UserNumber;
import baseball.util.BaseBallValues;

public class BaseBallService {

    private int ball;
    private int strike;
    private int[] com;

    public BaseBallService(ComNumber comNumber) {
        this.com = comNumber.getNumbers();
    }

    public boolean doService(UserNumber userNumber) {
        return checkNumbers(userNumber.getNumbers());
    }

    private void checkNumberBall(int idx, int[] user) {
        if (com[idx] == user[(idx + 1) % BaseBallValues.NUMBER_LENGTH] ||
                com[idx] == user[(idx + 2) % BaseBallValues.NUMBER_LENGTH]) {
            ball++;
        }
    }

    private void checkNumberStrike(int idx, int[] user) {
        if (com[idx] == user[idx]) {
            strike++;
        }
    }

    private String makeBallAndStrikeCount() {
        if (strike == BaseBallValues.NUMBER_LENGTH) {
            return strike + "스트라이크";
        }
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString();
    }

    private void printMessage() {
        System.out.println(makeBallAndStrikeCount());
    }

    private boolean checkNumbers(int[] user) {
        ball = strike = 0;
        for (int i = 0; i < BaseBallValues.NUMBER_LENGTH; i++) {
            checkNumberBall(i, user);
            checkNumberStrike(i, user);
        }

        for (int i =0 ; i < 3;i++) {
            System.out.print(com[i] + " ");
        }
        System.out.println();
        for (int i =0 ; i < 3;i++) {
            System.out.print(user[i] + " ");
        }
        System.out.println();

        printMessage();
        return strike != BaseBallValues.NUMBER_LENGTH;
    }

}
