package io.github.rostikq.task2;

import io.github.rostikq.logger.Logger;

public abstract class DeliveryCreator {
    public abstract DeliveryResult calculateAndCreateDelivery(String address, double weight);

    public void processDelivery(String address, double weight) {
        Logger.log("DeliveryProcess", "Крок 1: Перевірка адреси доставки (" + address + ")");
        Logger.log("DeliveryProcess", "Крок 2: Реєстрація ваги відправлення (" + weight + " кг)");

        DeliveryResult result = calculateAndCreateDelivery(address, weight);

        Logger.log("DeliveryProcess", "Крок 3: Призначення виконавця/маршруту");
        Logger.log("DeliveryProcess", "Крок 4: Зареєстровано в системі. Деталі: " + result);
    }
}
