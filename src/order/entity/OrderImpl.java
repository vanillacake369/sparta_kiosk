package order.entity;

import item.Order;
import item.product.entity.Product;

public class OrderImpl implements Order {

    private String text;
    private OrderState orderState;
    private String description;

    private OrderImpl(Builder builder) {
        this.text = builder.text;
        this.orderState = builder.orderState;
        this.description = builder.description;
    }

    @Override
    public OrderState getState() {
        return orderState;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }

    public static class Builder {

        private String text;
        private OrderState orderState;
        private String description;


        public Builder text(String val) {
            text = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder orderState(OrderState val) {
            orderState = val;
            return this;
        }

        public OrderImpl build() {
            return new OrderImpl(this);
        }
    }
}
