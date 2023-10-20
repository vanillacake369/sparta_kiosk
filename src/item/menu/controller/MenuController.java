package item.menu.controller;

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

    public String getMenusView() throws Exception {
        return menuView.getWholeMenuView();
    }

    public String getProductMenusView(int menuInput) throws Exception {
        return menuView.getProductMenusView(menuInput);
    }

    public int getProductInput(int menuInput) throws Exception {
        // 상품 메뉴 출력
        String productMenus = getProductMenusView(menuInput);
        System.out.println(productMenus);

        // 상품 메뉴 선택
        int productInput = scn.nextInt();
        return productInput;
    }

    public int getMenuInput() throws Exception {
        // 카테고리 메뉴 출력 => Menu Controller & View
        String menus = getMenusView();
        System.out.println(menus);

        // 카테고리 메뉴 사용자 선택
        int menuInput = scn.nextInt();
        return menuInput;
    }
}
