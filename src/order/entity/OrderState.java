package order.entity;

public enum OrderState {
    CONFIRM(1, "확인", "장바구니를 확인 후 주문합니다."),
    CANCEL(2, "취소", "진행 중인 주문을 취소합니다.");

    private int seq;
    private String text;
    private String description;

    OrderState(int seq, String text, String description) {
        this.seq = seq;
        this.text = text;
        this.description = description;
    }

    public int getSeq() {
        return seq;
    }

    public String getDescription() {
        return description;
    }
}
