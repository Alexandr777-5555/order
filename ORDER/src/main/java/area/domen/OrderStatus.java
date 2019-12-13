package area.domen;

public enum OrderStatus {

    START, CHECKED;

    public static OrderStatus fromValue(int value) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.ordinal() == value) {
                return status;
            }
        }
        throw new RuntimeException("неизвестно" + value);
    }
}
