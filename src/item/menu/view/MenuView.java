package item.menu.view;

import common.View;
import item.Item;
import item.menu.entity.Menu;

import java.util.List;

public class MenuView implements View {
    private final static String welcomeText = "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n";

    public static void printMenu() {
        System.out.println(welcomeText);
        System.out.println("====================================");
    }

    public String getView(List<Menu> itemMenus, List<Menu> orderMenus) {
        return welcomeText;
    }

    @Override
    public String getView(List<Item> menus, Long productMenuSize, Long orderMenuSize) {
        StringBuilder wholeMenu = new StringBuilder(welcomeText);
        wholeMenu.append("\n[ SHAKESHACK MENU ]\n");
        for (int i = 0; i < productMenuSize; i++) {
            Item item = menus.get(i);
            wholeMenu.append(i + ". " + item.getName() + "          |           " + item.getDescription() + "\n");
        }
        wholeMenu.append("\n[ ORDER MENU ]\n");
        for (int i = 0; i < orderMenuSize; i++) {
            Item item = menus.get((int) (productMenuSize + i));
            wholeMenu.append(i + ". " + item.getName() + "          |           " + item.getDescription() + "\n");
        }
        return wholeMenu.toString();
    }
}
