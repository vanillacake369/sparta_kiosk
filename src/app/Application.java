package app;

import item.menu.controller.MenuController;
import item.product.entity.ProductType;
import item.menu.service.MenuService;
import item.menu.view.MenuView;
import item.product.entity.Bucket;
import order.controller.OrderController;
import order.entity.OrderState;
import order.service.OrderService;
import order.view.OrderView;

import java.util.Scanner;

public class Application implements AutoCloseable {
    private static Application instance; // 앱 싱글톤 객체

    private final static Bucket bucket = Bucket.getInstance(); // 장바구니
    private final static Scanner scn = new Scanner(System.in); // 사용자 입출력
    private final static MenuView menuView = new MenuView();
    /* Menu */
    private final static MenuService menuService = new MenuService();
    private final static MenuController menuController = new MenuController(scn, menuService, menuView);

    /* Order */
    private final static OrderService orderService = new OrderService();
    private final static OrderView orderView = new OrderView();

    private final static OrderController orderController = new OrderController(scn, orderService, orderView);

    /* 대기번호 */
    private static Long waitingNumber = 0L;

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
        // 카테고리 메뉴 사용자 선택 => Menu
        int menuInput = menuController.getMenuInput();

        // 카테고리 선택 예외처리 
        if (isValidOption(menuInput) != true)
            return;

        // 구매 옵션인 경우 구매 진행 => Order
        if (0 < menuInput && menuInput < ProductType.values().length) {
            // 상품 선택
            int productInput = menuController.getProductInput(menuInput);
            // 장바구니에 추가 혹은 재주문
            orderController.addProduct(bucket, menuInput, productInput);
        }

        // 주문 시작 => Order
        if (menuInput == ProductType.values().length + 1) {
            // 주문 실행 ::
            waitingNumber = orderController.doOrder(bucket, waitingNumber);
        }

        // 주문 시작
        if (menuInput == ProductType.values().length + 2) {
            // 주문 취소 ::
            orderController.cancelOrder(bucket);
        }
    }

    /**
     * 입력 카테고리값이 올바른 입력인지 검증하는 함수
     * : 주문옵션과 카테고리옵션들의 크기합보다 크다면 valid하지 않으므로 false반환 
     * @param menuInput
     * @return
     */
    private static boolean isValidOption(int menuInput) {
        if (menuInput > OrderState.values().length + ProductType.values().length) {
            System.out.println("없는 옵션을 선택하셨습니다. 다시 입력해주세요");
            System.out.println();
            return false;
        }
        return true;
    }

    /* 객체 자동 메모리 삭제 함수 */
    @Override
    public void close() throws RuntimeException {
        System.out.println("close application");
        throw new IllegalStateException();
    }
}
