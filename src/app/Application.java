package app;

import item.Item;
import item.menu.controller.MenuController;
import item.menu.entity.ProductMenuType;
import item.menu.service.MenuService;
import item.menu.view.MenuView;
import item.product.entity.Bucket;
import order.entity.OrderState;

import java.util.Arrays;
import java.util.Scanner;

public class Application implements AutoCloseable {
    private static Application instance; // 앱 싱글톤 객체

    private final static Bucket bucket = Bucket.getInstance(); // 장바구니
    private final static Scanner scn = new Scanner(System.in); // 사용자 입출력
    private final static MenuService menuService = new MenuService(); // 메뉴 서비스 
    private final static MenuView menuView = new MenuView(); // 메뉴 뷰
    private final static MenuController menuController = new MenuController(menuService, menuView); // 메뉴 컨틀롤러 <- 메뉴 서비스, 메뉴 뷰 주입

    private Application() {
    }

    /* Application 싱글톤 구현 :: 필드 주입 */
    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public Scanner getScn() {
        return scn;
    }


    /* 키오스크 프로그램 메인 함수 */
    public void runKiosk() throws Exception {
        String menus = menuController.getMenus();
        System.out.println(menus);
        int menuInput = scn.nextInt();
        System.out.println("사용자 선택 옵션 : " + menuInput);

        // 예외처리
        if (menuInput > OrderState.values().length + ProductMenuType.values().length) {
            System.out.println("없는 옵션을 선택하셨습니다.");
        } else {
            // 상품 메뉴 출력
            String productMenus = menuController.getProductMenus(menuInput);
            System.out.println(productMenus);

            int productInput = scn.nextInt();

            System.out.println(productInput);

            // 상품 선택
            try (Item item = Arrays.stream(ProductMenuType.values())
                    .filter(p -> p.getSeq() == menuInput)
                    .map(p -> p.getItems().get(productInput))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new)) {
                System.out.println(item.toString());
                System.out.println("위 메뉴를 장바구니에 추가하겠습니까?");
                System.out.println(OrderState.CONFIRM.getText());
            }


        }
    }

    /* 객체 자동 메모리 삭제 함수 */
    @Override
    public void close() throws RuntimeException {
        System.out.println("close application");
        throw new IllegalStateException();
    }
}
