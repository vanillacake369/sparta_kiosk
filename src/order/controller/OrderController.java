package order.controller;

import item.menu.controller.MenuController;
import item.product.entity.Bucket;
import item.product.entity.Product;
import item.product.entity.ProductType;
import order.entity.OrderState;
import order.service.OrderService;
import order.view.OrderView;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderController {

    private final Scanner scn;
    private final OrderService orderService;
    private final OrderView orderView;

    public OrderController(Scanner scn, OrderService orderService, OrderView orderView) {
        this.scn = scn;
        this.orderService = orderService;
        this.orderView = orderView;
    }

    public void doOrder(Bucket bucket, MenuController menuController, int menuInput) throws Exception {
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


}
