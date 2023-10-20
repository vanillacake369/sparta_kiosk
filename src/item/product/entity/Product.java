package item.product.entity;

import item.Item;

public class Product implements Item {

    private String name;
    private String description;
    private Double price;

    /* make constructor "private" */
    private Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    private Product() {
    }


    /* Builder로 Product 생성 */
    private Product(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
    }

    /* 메뉴판에 출력을 위한 toString 오버라이딩 */
    @Override
    public String toString() {
        return name + "         |   "
                + description + "         |   "
                + price + "         |   " + "\n";
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

    @Override
    public void close() throws Exception {
        System.out.println("close Product");
        throw new IllegalStateException();

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
