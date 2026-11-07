package io.github.rostikq.task2;

import io.github.rostikq.logger.Logger;

public class FloorDeliveryCreator extends DeliveryCreator {
    @Override
    public DeliveryResult calculateAndCreateDelivery(String address, double weight) {
        Logger.log("FloorDelivery", "Розрахунок для доставки на поверх");
        double cost = 150.0 + weight * 25.0;
        return new DeliveryResult("Доставка на поверх", cost, 1);
    }
}
