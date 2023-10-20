package app;

import item.menu.controller.MenuController;
import item.product.entity.ProductType;
import item.menu.service.MenuService;
import item.menu.view.MenuView;
import item.product.entity.Bucket;
import item.product.entity.Product;
import order.entity.OrderState;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        // 카테고리 메뉴 출력 => Controller & View
        String menus = menuController.getMenus();
        System.out.println(menus);

        // 카테고리 메뉴 사용자 선택 => Application
        int menuInput = scn.nextInt();
        System.out.println("사용자 선택 옵션 : " + menuInput);

        // 카테고리 메뉴 사용자 선택 예외처리 =>
        if (menuInput > OrderState.values().length + ProductType.values().length) {
            System.out.println("없는 옵션을 선택하셨습니다. 다시 입력해주세요");
            System.out.println();
            return;
        }

        // 구매
        if (0 < menuInput && menuInput < ProductType.values().length) {

            // 상품 메뉴 출력
            String productMenus = menuController.getProductMenus(menuInput);
            System.out.println(productMenus);

            // 상품 메뉴 선택
            int productInput = scn.nextInt();
            System.out.println(productInput);

            // 상품 선택
            Product product = Arrays.stream(ProductType.values())
                    .filter(p -> p.getSeq() == menuInput)
                    .map(p -> p.getItems().get(productInput - 1))// index로 가져오므로 -1
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);

            // 장바구니 추가 여부 출력
            System.out.println(product.toString());
            System.out.println("위 메뉴를 장바구니에 추가하겠습니까?");
            AtomicInteger orderOptionSeq = new AtomicInteger(1);
            String orderOptions = Arrays.stream(OrderState.values()).map(orderState -> orderOptionSeq.getAndIncrement() + orderState.getText()).collect(Collectors.joining());
            System.out.println(orderOptions);

            // 장바구니 추가 여부 입력
            int orderInput = scn.nextInt();
            System.out.println(orderInput);

            // 추가 로직
            if (orderInput == 1) {
                System.out.println("장바구니에 추가");
                bucket.addProduct(product);
                String bucketState = bucket.showBucket();
                System.out.println(bucketState);
            }
            if (orderInput == 2) {
                System.out.println("주문 취소");
            }
        }

        // 주문
        if (menuInput > ProductType.values().length) {
            if (menuInput == ProductType.values().length + 1) { // 주문 시작
                System.out.println("주문 시작");
                // 주문시작 뷰 
                // 주문 옵션 / 메뉴판 옵션 선택
                // 선택에 따른 로직 / 뷰 구현 :: 대기번호 출력 / 장바구니 비우기 / 3초 딜레이
                // return void;
            }

            if (menuInput == ProductType.values().length + 2) { // 주문 취소
                System.out.println("주문 취소");
                // 주문취소 뷰 
                // 장바구니 비우기
                // return void;
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
