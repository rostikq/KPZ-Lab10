package io.github.rostikq.task2;

import io.github.rostikq.logger.Logger;

public class BranchDeliveryCreator extends DeliveryCreator {
    @Override
    public DeliveryResult calculateAndCreateDelivery(String address, double weight) {
        Logger.log("BranchDelivery", "Розрахунок для відділення");
        double cost = 40.0 + weight * 8.0;
        return new DeliveryResult("Доставка у відділення", cost, 3);
    }
}
