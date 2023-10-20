package order.controller;

import item.product.entity.Bucket;
import item.product.entity.Product;
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

    public void doOrder(Bucket bucket, int menuInput, int productInput) throws Exception {
        // 상품 선택
        Product product = orderService.findProductByMenuNumAndProductNum(menuInput, productInput);

        // 장바구니 추가 여부 출력
        orderService.getAskingAddBucketView(product);

        // 장바구니 추가 여부 입력
        int orderInput = scn.nextInt();
        System.out.println(orderInput);

        // 추가 로직
        if (orderInput == 1) {
            orderService.addProductToBucket(bucket, product);
        }
        if (orderInput == 2) {
            System.out.println("주문 취소");
        }
    }


}
