package order.controller;

import item.product.entity.Bucket;
import item.product.entity.ProductType;
import order.service.OrderService;
import order.view.OrderView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    private final static Bucket bucket = Bucket.getInstance(); // 장바구니
    private final static Scanner scn = new Scanner(System.in); // 사용자 입출력

    private final static OrderService orderService = new OrderService();
    private final static OrderView orderView = new OrderView();

    private final static OrderController orderController = new OrderController(scn, orderService, orderView);

    static Long waitingNum = 0L;

    @Test
    @DisplayName("장바구니에 있는 상품 주문 후, 대기번호가 늘어납니다.")
    void increaseWaitingNumberWhenDoOrder() {
        // GIVEN
        bucket.addProduct(ProductType.BURGERS.getItems().get(0));
        bucket.addProduct(ProductType.BURGERS.getItems().get(1));

        // WHEN
        try {
            waitingNum = orderController.handleOrder(bucket, waitingNum, 1);
        } catch (Exception e) {
        }

        // THEN
        assertEquals(1, waitingNum);

    }

    @Test
    @DisplayName("n초 딜레이 화면을 출력합니다.")
    void testDelay() {
        try {
            orderController.delayBySecs(3);
        } catch (Exception e) {

        }
    }

}