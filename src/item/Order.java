package item;

import order.entity.OrderState;

public interface Order {
    public OrderState getState();

    public String getDescription();
}
