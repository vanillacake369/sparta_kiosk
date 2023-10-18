package item.product.entity;

import item.Item;

public class Product implements Item {

    private String name;
    private String description;
    private Long price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }
}
