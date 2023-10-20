package order.entity;

import item.menu.entity.ProductMenuType;

public enum OrderState {
    CONFIRM("확인", "장바구니를 확인 후 주문합니다."),
    CANCEL("취소", "진행 중인 주문을 취소합니다.");

    private String text;
    private String description;

    OrderState(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getText() {
        return text;
    }
}
