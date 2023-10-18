package item.menu.view;

import item.menu.entity.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuViewTest {

    @Test
    @DisplayName("동일한 메뉴들을 가지고 있습니다.")
    public void hasSameMenus() throws Exception {
        // GIVEN
        MenuView.initMenu();

        // WHEN
        List<Menu> menus1 = MenuView.getMenus();
        List<Menu> menus2 = MenuView.getMenus();

        // THEN
        assertEquals(menus1.equals(menus2), true);

    }
}