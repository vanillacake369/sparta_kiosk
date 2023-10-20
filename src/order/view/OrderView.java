package order.view;

import item.product.entity.Bucket;
import item.product.entity.Product;
import order.entity.OrderState;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderView {
    public static void getStartOrderView(Bucket bucket) {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println();

        System.out.println("[ Orders ]");
        System.out.println(bucket.showBucket());
        System.out.println();

        System.out.println("[ Total ]");
        System.out.println(String.format("W %s", bucket.calculateAllPrice()));
        System.out.println();

        System.out.println("1. 주문       2. 메뉴판");
    }

    public void getAskingAddBucketView(Product product) {
        System.out.println(product.toString());
        System.out.println("위 메뉴를 장바구니에 추가하겠습니까?");

        // 주문 상태 출력 :: (1.확인, 2.취소)
        AtomicInteger orderOptionSeq = new AtomicInteger(1);
        String orderOptions = Arrays.stream(OrderState.values())
                .map(orderState -> String.format("%s. %s    ",
                        orderOptionSeq.getAndIncrement(),
                        orderState.getText()))
                .collect(Collectors.joining());

        System.out.println(orderOptions);
    }

    public static void showBucketStatus(Bucket bucket) {
        System.out.println("현재 장바구니 목록 ");
        System.out.println("==================");
        System.out.println(bucket.showBucket());
        System.out.println("==================");
    }
}
