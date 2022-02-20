package baseball.domain;

import baseball.Application;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class UserNumber extends NSTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 유저_값_중복_체크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            run("111");
            verify("[ERROR] 유저 값이 중복되었습니다.");
        }
    }

    @Test
    void 유저_값_유효성_초과_체크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            run("1357");
            verify("[ERROR] 유저 값이 너무 많습니다.");
        }
    }

    @Test
    void 유저_값_유효성_미만_체크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            run("13");
            verify("[ERROR] 유저 값이 너무 적습니다.");
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
