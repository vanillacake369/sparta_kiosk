package item.menu.controller;

import common.Service;
import common.View;

public class MenuController {
    Service menuService;
    View menuView;

    public MenuController(View menuView) {
        this.menuView = menuView;
    }

    public MenuController(Service menuService, View menuView) {
        this.menuService = menuService;
        this.menuView = menuView;
    }

    public String getMenus() {
        return menuService.getMenus(menuView);
    }
}
