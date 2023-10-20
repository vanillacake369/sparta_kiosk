package order.view;

import item.product.entity.Bucket;
import item.product.entity.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderViewTest {
    public static Bucket bucket = Bucket.getInstance();
    public static OrderView orderView = new OrderView();

    @Test
    @DisplayName("주문 여부 화면이 나옵니다.")
    void test_getStartOrderView() {
        // GIVEN
        bucket.addProduct(ProductType.BURGERS.getItems().get(0));
        bucket.addProduct(ProductType.BURGERS.getItems().get(1));
        bucket.addProduct(ProductType.BURGERS.getItems().get(2));

        // WHEN
        orderView.getStartOrderView(bucket);

        // THEN
    }
}