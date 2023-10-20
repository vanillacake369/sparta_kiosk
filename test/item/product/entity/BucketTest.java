package item.product.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketTest {

    @Test
    @DisplayName("장바구니의 모든 제품의 총 합을 구합니다.")
    void testCalculateAllPrice() {
        // GIVEN
        Bucket bucket = Bucket.getInstance();
        // 25.2
        bucket.addProduct(ProductType.BURGERS.getItems().get(0)); // 6.9
        bucket.addProduct(ProductType.BURGERS.getItems().get(1)); // 8.9
        bucket.addProduct(ProductType.BURGERS.getItems().get(2)); // 9.4

        // WHEN
        Double sum = bucket.calculateAllPrice();

        // THEN
        assertEquals(25.2, sum);

    }

    @Test
    @DisplayName("장바구니 안에 있는 상품들을 출력합니다.")
    void test_showBucket() {
        // GIVEN
        Bucket bucket = Bucket.getInstance();
        bucket.addProduct(ProductType.BURGERS.getItems().get(0)); // 6.9
        bucket.addProduct(ProductType.BURGERS.getItems().get(1)); // 8.9
        bucket.addProduct(ProductType.BURGERS.getItems().get(2)); // 9.4

        // WHEN
        String bucketStatus = bucket.showBucket();

        // THEN
        assertEquals("ShackBurger     | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                "SmokeShack      | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                "Shroom Burger   | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", bucketStatus);
    }
}