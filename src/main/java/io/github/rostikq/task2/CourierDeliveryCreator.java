package io.github.rostikq.task2;

import io.github.rostikq.logger.Logger;

public class CourierDeliveryCreator extends DeliveryCreator {
    @Override
    public DeliveryResult calculateAndCreateDelivery(String address, double weight) {
        Logger.log("CourierDelivery", "Розрахунок для кур'єрської доставки");
        double cost = 100.0 + weight * 15.0;
        return new DeliveryResult("Кур'єрська доставка", cost, 1);
    }
}
