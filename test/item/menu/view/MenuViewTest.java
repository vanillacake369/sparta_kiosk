package item.menu.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuViewTest {
    final MenuView menuView = new MenuView();

    @Test
    @DisplayName("메뉴판을 출력합니다.")
    void getView() {
        // GIVEN
        String view = menuView.getWholeMenuView();

        // WHEN
        // THEN
        System.out.println(view);
    }

    @Test
    @DisplayName("선택한 상품에 대한 메뉴판을 보여줍니다.")
    void getProductMenuView() {
        // GIVEN
        int menuInput = 1;

        assertDoesNotThrow(() -> {
            // WHEN
            String productMenuView = menuView.getProductMenusView(menuInput);
            // THEN
            System.out.println(productMenuView);
        });
    }

    @Test
    @DisplayName("선택한 상품이 없는 경우 예외를 처리합니다.")
    void throwExceptionWhenProductNotExists() {
        // GIVEN
        int menuInput = -1000000;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            // WHEN
            String productMenuView = menuView.getProductMenusView(menuInput);
        });

        assertEquals("해당 메뉴는 메뉴판에 없는 메뉴입니다.", exception.getMessage());
    }
}