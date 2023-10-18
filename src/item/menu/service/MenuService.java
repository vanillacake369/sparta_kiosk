package item.menu.service;

import common.Service;
import common.View;
import item.menu.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuService implements Service {
    // ShakeshackMenuStateHolder을 주입할지
    // 아니면 아래와 같이 service에서 그냥 만들어낼지
    private final static List<Menu> menus = new ArrayList<>();

    private static void init() {
        if (menus.isEmpty()) {
            menus.add(new Menu.Builder().name("Burgers").description("앵거스 비프 통살을 다져 만든 버거").build());
            menus.add(new Menu.Builder().name("Forzen Custard").description("매장에서 신선하게 만드는 아이스크림").build());
            menus.add(new Menu.Builder().name("Drinks").description("매장에서 직접 만드는 음료").build());
            menus.add(new Menu.Builder().name("Beer").description("뉴욕 브루클린 브루어리에서 양조한 맥주").build());
        }
    }

    public static List<Menu> getMenus() {
        return menus;
    }

    @Override
    public String getMenus(View menuView) {
        return menuView.getView();
//        return menuView.getView(menus, menus); => 상품 메뉴  & 주문여부 메뉴
    }
}
