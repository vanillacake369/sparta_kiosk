package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    @DisplayName("싱글톤 객체가 생성되는지 확인합니다.")
    void getInstance() {
        Application application1 = Application.getInstance();
        Application application2 = Application.getInstance();

        assertEquals(application1,application2);
    }

    @Test
    @DisplayName("앱이 실행되는지 체크합니다.")
    void runKiosk() {
    }
}