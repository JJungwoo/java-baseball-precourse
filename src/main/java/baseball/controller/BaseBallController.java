package baseball.controller;

import baseball.domain.ComNumber;
import baseball.domain.UserNumber;
import baseball.service.BaseBallService;
import baseball.util.BaseBallValues;
import nextstep.utils.Console;

public class BaseBallController {

    public void run() {
        BaseBallService baseBallService = new BaseBallService(
                new ComNumber(new int[BaseBallValues.NUMBER_LENGTH]));
        UserNumber userNumber;

        do {
            userNumber = inputUserCommand();
        } while(baseBallService.doService(userNumber));

        endBaseBallGame();
    }

    private UserNumber inputUserCommand() {
        System.out.print("숫자를 입력해주세요 : ");
        return new UserNumber(Console.readLine());
    }

    private void endBaseBallGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (Integer.parseInt(Console.readLine()) == BaseBallValues.GAME_END_SIGNAL) {
            run();
        }
    }

}
