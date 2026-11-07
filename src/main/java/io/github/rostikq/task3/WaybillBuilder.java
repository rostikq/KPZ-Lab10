package io.github.rostikq.task3;

import io.github.rostikq.logger.Logger;

public class WaybillBuilder {
    private String sender;
    private String recipient;
    private String recipientPhone;
    private double weight;
    private boolean declaredValue;
    private boolean cashOnDelivery;
    private boolean returnDocuments;
    private boolean packagingService;
    private boolean insurance;

    public WaybillBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public WaybillBuilder setRecipient(String recipient, String recipientPhone) {
        this.recipient = recipient;
        this.recipientPhone = recipientPhone;
        return this;
    }

    public WaybillBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public WaybillBuilder setDeclaredValue(boolean declaredValue) {
        this.declaredValue = declaredValue;
        return this;
    }

    public WaybillBuilder setCashOnDelivery(boolean cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
        return this;
    }

    public WaybillBuilder setReturnDocuments(boolean returnDocuments) {
        this.returnDocuments = returnDocuments;
        return this;
    }

    public WaybillBuilder setPackagingService(boolean packagingService) {
        this.packagingService = packagingService;
        return this;
    }

    public WaybillBuilder setInsurance(boolean insurance) {
        this.insurance = insurance;
        return this;
    }

    // Геттери для доступу класу Waybill
    String getSender() { return sender; }
    String getRecipient() { return recipient; }
    String getRecipientPhone() { return recipientPhone; }
    double getWeight() { return weight; }
    boolean isDeclaredValue() { return declaredValue; }
    boolean isCashOnDelivery() { return cashOnDelivery; }
    boolean isReturnDocuments() { return returnDocuments; }
    boolean isPackagingService() { return packagingService; }
    boolean isInsurance() { return insurance; }

    public Waybill build() {
        if (sender == null || sender.trim().isEmpty()) {
            Logger.log("WaybillBuilder", "Неможливо сформувати накладну: не вказано відправника");
            throw new IllegalStateException("Не вказано відправника");
        }
        if (recipientPhone == null || recipientPhone.trim().isEmpty()) {
            Logger.log("WaybillBuilder", "Неможливо сформувати накладну: не вказано телефон отримувача");
            throw new IllegalStateException("Неможливо сформувати накладну: не вказано телефон отримувача");
        }
        if (weight <= 0) {
            Logger.log("WaybillBuilder", "Неможливо сформувати накладну: вага має бути більшою за нуль");
            throw new IllegalStateException("Вага має бути більшою за нуль");
        }

        Waybill waybill = new Waybill(this);
        Logger.log("WaybillBuilder", "Накладна успішно сформована та перевірена.");
        return waybill;
    }

    // Метод створення типової накладної «документи»
    public static Waybill buildTypicalDocuments(String sender, String recipient, String phone) {
        Logger.log("WaybillDirector", "Формування типової накладної 'Документи'");
        return new WaybillBuilder()
                .setSender(sender)
                .setRecipient(recipient, phone)
                .setWeight(0.5)
                .setReturnDocuments(true)
                .build();
    }
}
