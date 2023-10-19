package item.product.entity;

import item.Item;

public class Product implements Item {

    private String name;
    private String description;
    private Double price;

    private Product(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public static class Builder {

        private String name;
        private String description;
        private Double price;

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder price(Double val) {
            price = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
