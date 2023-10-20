package order.view;

import item.product.entity.Bucket;

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

    public static void showBucketStatus(Bucket bucket) {
        System.out.println("현재 장바구니 목록 ");
        System.out.println("==================");
        System.out.println(bucket.showBucket());
        System.out.println("==================");
    }
}
