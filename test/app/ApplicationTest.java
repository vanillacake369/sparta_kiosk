package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    @Test
    @DisplayName("싱글톤 객체는 하나이어야 합니다.")
    void getInstance() {
        // GIVEN
        Application application1 = Application.getInstance();
        Application application2 = Application.getInstance();

        // WHEN & THEN
        assertEquals(application1, application2);
    }

    @Test
    @DisplayName("Application객체는 단 하나의 scanner를 공유합니다.")
    void isSharingSameScanner() {
        // GIVEN
        Application app1 = Application.getInstance();
        Application app2 = Application.getInstance();

        // WHEN
        Scanner scn1 = app1.getScn();
        Scanner scn2 = app2.getScn();

        // THEN
        assertEquals(scn1, scn2);
    }
}