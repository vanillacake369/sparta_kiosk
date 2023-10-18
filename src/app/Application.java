package app;

import item.menu.controller.MenuController;
import item.menu.service.MenuService;
import item.menu.view.MenuView;

import java.util.Scanner;

public class Application implements AutoCloseable {
    private static Application instance;

    private final Scanner scn = new Scanner(System.in);
    private final MenuController menuController = new MenuController(new MenuService(), new MenuView());

    private Application() {
    }

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public Scanner getScn() {
        return scn;
    }

    public void runKiosk() throws Exception {
        String menus = menuController.getMenus();
        System.out.println(menus);
        System.out.println("사용자 입력 : " + scn.next());
    }

    @Override
    public void close() throws RuntimeException {
        System.out.println("close");
        throw new IllegalStateException();
    }
}
