package baseball.domain;

import baseball.Application;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ComNumber extends NSTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 컴퓨터_값_중복_체크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 1, 1);
            run("135");
            verify("[ERROR] 컴퓨터 값이 중복되었습니다.");
        }
    }

    @Test
    void 컴퓨터_값_유효성_초과_체크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5, 7);
            run("135");
            verify("[ERROR] 컴퓨터 값이 너무 많습니다.");
        }
    }

    @Test
    void 컴퓨터_값_유효성_미만_체크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3);
            run("135");
            verify("[ERROR] 컴퓨터 값이 너무 적습니다.");
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
