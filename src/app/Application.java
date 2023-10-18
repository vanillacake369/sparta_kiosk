package app;

import item.menu.view.MenuView;

import java.util.Scanner;

public class Application implements AutoCloseable {
    private static Application instance;

    private final Scanner scn = new Scanner(System.in);

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
        MenuView.printMenu();

        String menuInput = scn.next();
        System.out.println("입력 사용자 값 == " + menuInput);
    }

    @Override
    public void close() throws RuntimeException {
        System.out.println("close");
        throw new IllegalStateException();
    }
}
