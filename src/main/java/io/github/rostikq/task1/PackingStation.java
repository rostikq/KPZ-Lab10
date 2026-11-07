package io.github.rostikq.task1;

import io.github.rostikq.logger.Logger;

public class PackingStation {
    public void packShipment(String shipmentName, PackagingFactory factory) {
        Logger.log("PackingStation", "Початок пакування відправлення: " + shipmentName);

        Box box = factory.createBox();
        Filler filler = factory.createFiller();
        Label label = factory.createLabel();

        Logger.log("PackingStation", "Склад комплекту для [" + shipmentName + "]: "
                + box.getDescription() + ", "
                + filler.getDescription() + ", "
                + label.getDescription());
    }
}