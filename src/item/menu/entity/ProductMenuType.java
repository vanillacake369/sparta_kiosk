package item.menu.entity;

import item.Item;
import item.product.entity.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ProductMenuType {
    BURGERS(1, "Burgers", "앵거스 비프 통살을 다져만든 버거",
            Arrays.asList(
                    new Product.Builder()
                            .name("ShackBurger")
                            .description("토마토, 양상추, 쉑소스가 토핑된 치즈버거")
                            .price(6.9)
                            .build(),
                    new Product.Builder()
                            .name("SmokeShack")
                            .description("베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거")
                            .price(8.9)
                            .build(),
                    new Product.Builder()
                            .name("Shroom Burger")
                            .description("몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거")
                            .price(9.4)
                            .build(),
                    new Product.Builder()
                            .name("Cheese Burger")
                            .description("포테이토 번과 비프패티, 치즈가 토핑된 치즈버거")
                            .price(6.9)
                            .build(),
                    new Product.Builder()
                            .name("Hamburger")
                            .description("비프패티를 기반으로 야채가 들어간 기본버거")
                            .price(5.4)
                            .build()
            )
    ),
    FORZEN_CUSTARD(2, "Forzen Custard", "매장에서 신선하게 만드는 아이스크림",
            Arrays.asList(
                    new Product.Builder().build(),
                    new Product.Builder().build()
            )
    ),
    DRINKS(3, "Drinks", "매장에서 직접 만드는 음료",
            Arrays.asList(
                    new Product.Builder().build(),
                    new Product.Builder().build()
            )
    ),
    BEER(4, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주",
            Arrays.asList(
                    new Product.Builder().build(),
                    new Product.Builder().build()
            )
    ),
    NONE(-1, "None", "없음", Collections.EMPTY_LIST);


    private int seq;
    private String name;
    private String description;
    private List<Item> items;

    ProductMenuType(int seq, String name, String description, List<Item> items) {
        this.seq = seq;
        this.name = name;
        this.items = items;
    }

    public static ProductMenuType findByProductName(String name) {
        return Arrays.stream(ProductMenuType.values())
                .filter(p -> p.hasName(name))
                .findFirst()
                .orElse(NONE);
    }

    public boolean hasName(String name) {
        return items.stream().anyMatch(i -> i.getName().equals(name));
    }

    public int getSeq() {
        return seq;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }
}
