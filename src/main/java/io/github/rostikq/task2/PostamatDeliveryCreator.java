package io.github.rostikq.task2;

import io.github.rostikq.logger.Logger;

public class PostamatDeliveryCreator extends DeliveryCreator {
    @Override
    public DeliveryResult calculateAndCreateDelivery(String address, double weight) {
        Logger.log("PostamatDelivery", "Розрахунок для поштомату");
        double cost = 50.0 + weight * 10.0;
        return new DeliveryResult("Доставка у поштомат", cost, 2);
    }
}
