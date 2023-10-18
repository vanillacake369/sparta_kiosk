package item.menu.view;

import item.menu.entity.MainMenuImpl;
import item.menu.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuView {
    private final static List<Menu> menus = new ArrayList<>();
    private final static String welcomeText = "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
            "\n" +
            "[ SHAKESHACK MENU ]\n" +
            "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
            "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
            "3. Drinks          | 매장에서 직접 만드는 음료\n" +
            "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
            "\n" +
            "[ ORDER MENU ]\n" +
            "5. Order       | 장바구니를 확인 후 주문합니다.\n" +
            "6. Cancel      | 진행중인 주문을 취소합니다.";

    public static void printMenu() {
        initMenu();

        System.out.println(welcomeText);
        System.out.println("====================================");
    }

    public static void initMenu() {
        if (menus.isEmpty()) {
            menus.add(new MainMenuImpl.Builder().name("Burgers").description("앵거스 비프 통살을 다져 만든 버거").build());
            menus.add(new MainMenuImpl.Builder().name("Forzen Custard").description("매장에서 신선하게 만드는 아이스크림").build());
            menus.add(new MainMenuImpl.Builder().name("Drinks").description("매장에서 직접 만드는 음료").build());
            menus.add(new MainMenuImpl.Builder().name("Beer").description("뉴욕 브루클린 브루어리에서 양조한 맥주").build());
        }
    }

    public static List<Menu> getMenus() {
        return menus;
    }
}
