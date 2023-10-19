package item.menu.entity;

import item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMenuTypeTest {
    @Test
    @DisplayName("ProductType 호출 시 새로운 Product List 가 계속 생성됩니다.")
    public void keepCreatingNewProducts() throws Exception {
        // GIVEN
        ProductMenuType burgers1 = ProductMenuType.BURGERS;
        ProductMenuType burgers2 = ProductMenuType.BURGERS;

        // WHEN
        Item item1 = burgers1.getItems().get(0);
        Item item2 = burgers2.getItems().get(0);

        // THEN
        assertEquals(item1, item2);
        System.out.println(item1);
        System.out.println(item2);
    }
}