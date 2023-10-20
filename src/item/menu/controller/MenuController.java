package item.menu.controller;

import common.Service;
import common.View;

public class MenuController {
    Service menuService;
    View menuView;

    public MenuController(Service menuService, View menuView) {
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
