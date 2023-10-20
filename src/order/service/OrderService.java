package order.service;

import item.product.entity.Bucket;
import item.product.entity.Product;
import item.product.entity.ProductType;
import order.entity.OrderState;
import order.view.OrderView;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderService {

    public Product findProductByMenuNumAndProductNum(int menuInput, int productInput) {
        return Arrays.stream(ProductType.values())
                .filter(p -> p.getSeq() == menuInput) // 해당 카테고리에 접근
                .map(p -> p.getItems().get(productInput - 1))// 해당 상품에 접근 :: index로 가져오므로 -1
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾으시는 상품이 없습니다.")); // 없다면 IllegalArgumentException 예외 던짐
    }


    // 실제 장바구니에 제품 추가
    public void addProductToBucket(Bucket bucket, Product product) {
        bucket.addProduct(product); // 장바구니에 제품 추가
        OrderView.showBucketStatus(bucket); // 주어진 뷰 포맷에 따라 장바구니 상태 출력
    }


}
