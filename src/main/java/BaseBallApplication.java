import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BaseBallApplication {

    private static final int BASEBALL_NUMBER_SIZE = 3;

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> userNumbers = new ArrayList<>();
        ArrayList<Integer> comNumbers = new ArrayList<>();
        int gameEndCheck;

        do {

            for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
                comNumbers.add(random.nextInt(9) + 1);
                for (int j = 0; j < i; j++) {
                    if (comNumbers.get(i).equals(comNumbers.get(j))) {
                        comNumbers.remove(i);
                        i--;
                        break;
                    }
                }
            }

            do {
                System.out.println("숫자를 입력해주세요 : ");
                String userInput = scanner.next();

                for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
                    userNumbers.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
                }

                int ball = 0;
                int strike = 0;

                for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
                    for (int j = 0; j < BASEBALL_NUMBER_SIZE; j++) {
                        if (userNumbers.get(i).equals(comNumbers.get(j))) {
                            if (i == j) strike++;
                            else ball++;
                            break;
                        }
                    }
                }

                if (strike > 0) {
                    System.out.print(strike + " 스트라이크 ");
                }
                if (ball > 0) {
                    System.out.print(ball + " 볼");
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }
                System.out.println();

                if (strike == BASEBALL_NUMBER_SIZE) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                userNumbers.clear();
            } while(true);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameEndCheck = scanner.nextInt();

            comNumbers.clear();
        } while(gameEndCheck == 1);
    }
}