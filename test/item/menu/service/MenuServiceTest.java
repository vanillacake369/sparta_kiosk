package item.menu.service;

import common.Service;
import common.View;
import item.Item;
import item.menu.view.MenuView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MenuServiceTest {
    private final Service menuService = new MenuService();

    @Test
    @DisplayName("메뉴판을 출력합니다.")
    void getMenus() {
        // GIVEN
        View menuView = new MenuView();

        // WHEN
        String menus = menuService.getMenusStr(menuView);

        // THEN
        System.out.println(menus);
    }


    @Test
    @DisplayName("생성한 아이템 메뉴 리스트가 항상 동일한지 확인합니다.")
    void isAlwaysSameItemMenus() {
        // GIVEN & WHEN
        List<Item> menus1 = MenuService.getMenus();
        List<Item> menus2 = MenuService.getMenus();

        // THEN
        assertEquals(menus1.equals(menus2), true);
        assertEquals(menus1.size(), 6);
        assertEquals(menus2.size(), 6);
    }

    @Test
    @DisplayName("생성한 아이템 메뉴에 접근합니다.")
    void getItem() {
        List<Item> menus = MenuService.getMenus();
        Item item = menus.get(0);
        System.out.println(item.getName());
        System.out.println(item.getDescription());
    }
}