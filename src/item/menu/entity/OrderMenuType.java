package item.menu.entity;

import item.Item;
import item.product.entity.Product;

import java.util.Arrays;
import java.util.List;

public enum OrderMenuType {

    ORDER(5, "Order", "장바구니를 확인 후 주문합니다.",
            Arrays.asList(
                    new Product.Builder().build(),
                    new Product.Builder().build(),
                    new Product.Builder().build()
            )
    ),
    CANCEL(6, "Cancel", "진행중인 주문을 취소합니다.",
            Arrays.asList(
                    new Product.Builder().build(),
                    new Product.Builder().build(),
                    new Product.Builder().build()
            )
    );

    private int seq;
    private String burgers;
    private String s;
    private List<Item> items;

    OrderMenuType(int seq, String burgers, String s, List<Item> items) {
        this.seq = seq;
        this.burgers = burgers;
        this.items = items;
    }

    public int getSeq() {
        return seq;
    }

    public String getBurgers() {
        return burgers;
    }

    public String getS() {
        return s;
    }
}
