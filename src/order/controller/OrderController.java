package order.controller;

import item.product.entity.Bucket;
import item.product.entity.Product;
import order.service.OrderService;
import order.view.OrderView;

import java.util.Scanner;

public class OrderController {

    private final Scanner scn;
    private final OrderService orderService;
    private final OrderView orderView;

    public OrderController(Scanner scn, OrderService orderService, OrderView orderView) {
        this.scn = scn;
        this.orderService = orderService;
        this.orderView = orderView;
    }

    /**
     * 장바구니 처리
     * 1. 상품 선택
     * 2. 장바구니에 추가 여부 묻기
     * 3. 확인,취소에 따라 장바구니 상태 처리
     * @param bucket
     * @param menuInput
     * @param productInput
     * @throws Exception
     */

    public void addProduct(Bucket bucket, int menuInput, int productInput) throws Exception {
        // 상품 선택
        Product product = orderService.findProductByMenuNumAndProductNum(menuInput, productInput);

        // 장바구니 추가 여부 출력
        orderView.getAskingAddBucketView(product);

        // 장바구니 추가 여부 입력
        int orderInput = scn.nextInt();

        // 추가 로직
        if (orderInput == 1) {
            orderService.addProductToBucket(bucket, product);
        }
        if (orderInput == 2) {
            System.out.println("주문 취소");
        }
    }

    /**
     * 주문 뷰, 옵션 선택 이후, 주문 처리 실행
     * @used Application
     *
     * @param bucket
     * @param waitingNumber
     * @return
     * @throws Exception
     */
    public Long doOrder(Bucket bucket, Long waitingNumber) throws Exception {
        // 주문시작 뷰       
        orderView.getStartOrderView(bucket);

        // 주문 옵션 선택
        int check = scn.nextInt();

        // 주문 처리 후 대기 번호 반환
        return handleOrder(bucket, waitingNumber, check);
    }

    /**
     * 주문 처리
     *
     * @use
     * - 장바구니 bucket :: Bucket
     * - 대기번호 waintingNumber :: Long
     *
     * @exception
     * 옵션이 옵션상태보다 큰 경우 예외를 반환합니다.
     *
     * @param bucket
     * @param waitingNumber
     * @param check
     * @return
     * @throws InterruptedException
     */
    protected Long handleOrder(Bucket bucket, Long waitingNumber, int check) throws InterruptedException {
        if (check > 2) {
            throw new IllegalArgumentException("장바구니 추가 옵션은 2를 초과할 수 없습니다.");
        }
        if (check == 1) {
            // 대기번호 출력 / 장바구니 비우기 / 3초 딜레이
            return makeOrder(bucket, waitingNumber);
        }
        if (check == 2) {
            cancelOrder(bucket);
        }
        return waitingNumber;
    }

    // 주문 실행, 장바구니 비운 뒤, 대기 화면 출력
    private Long makeOrder(Bucket bucket, Long waitingNumber) throws InterruptedException {
        System.out.println("주문이 완료되었습니다.");
        System.out.println(String.format("대기번호는 [ %s ] 번 입니다.", ++waitingNumber));
        delayBySecs(3);
        bucket.removeAll();
        return waitingNumber;
    }

    // second 에 따른 딜레이 대기화면 출력 
    protected void delayBySecs(int second) throws InterruptedException {
        for (int i = second; i > 0; i--) {
            System.out.println(String.format("(%s초 후 초기 메뉴판으로 돌아갑니다.)", i));
            Thread.sleep(1000);
        }
    }

    public void cancelOrder(Bucket bucket) {
        // 주문취소 뷰
        System.out.println("진행하던 주문이 취소되었습니다.");
        // 장바구니 비우기
        bucket.removeAll();
    }
}
