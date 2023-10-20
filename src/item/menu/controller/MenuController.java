package item.menu.controller;

import item.menu.entity.Menu;
import item.menu.service.MenuService;
import item.menu.view.MenuView;

import java.util.Scanner;

public class MenuController {
    MenuService menuService;
    MenuView menuView;

    private final Scanner scn;

    public MenuController(Scanner scn, MenuService menuService, MenuView menuView) {
        this.scn = scn;
        this.menuService = menuService;
        this.menuView = menuView;
    }

    public String getMenus() throws Exception {
        return menuView.getWholeMenuView();
    }

    public String getProductMenus(int menuInput) throws Exception {
        return menuView.getProductMenusView(menuInput);
    }
}
