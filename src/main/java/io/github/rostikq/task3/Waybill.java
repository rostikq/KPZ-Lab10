package io.github.rostikq.task3;

public class Waybill {
    private final String sender;
    private final String recipient;
    private final String recipientPhone;
    private final double weight;
    private final boolean declaredValue;
    private final boolean cashOnDelivery;
    private final boolean returnDocuments;
    private final boolean packagingService;
    private final boolean insurance;

    // Конструктор доступний тільки в межах пакета для Builder
    Waybill(WaybillBuilder builder) {
        this.sender = builder.getSender();
        this.recipient = builder.getRecipient();
        this.recipientPhone = builder.getRecipientPhone();
        this.weight = builder.getWeight();
        this.declaredValue = builder.isDeclaredValue();
        this.cashOnDelivery = builder.isCashOnDelivery();
        this.returnDocuments = builder.isReturnDocuments();
        this.packagingService = builder.isPackagingService();
        this.insurance = builder.isInsurance();
    }

    @Override
    public String toString() {
        return "Накладна [Відправник: " + sender + ", Отримувач: " + recipient +
                " (тел: " + recipientPhone + "), Вага: " + weight + " кг | Опції: " +
                (declaredValue ? "Оголошена цінність; " : "") +
                (cashOnDelivery ? "Накладений платіж; " : "") +
                (returnDocuments ? "Зворотні документи; " : "") +
                (insurance ? "Страхування" : "") + "]";
    }
}