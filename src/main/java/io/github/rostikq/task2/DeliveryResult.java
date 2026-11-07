package io.github.rostikq.task2;

public class DeliveryResult {
    private final String type;
    private final double cost;
    private final int days;

    public DeliveryResult(String type, double cost, int days) {
        this.type = type;
        this.cost = cost;
        this.days = days;
    }

    @Override
    public String toString() {
        return type + " [Вартість: " + cost + " грн, Строк: " + days + " дн.]";
    }
}
