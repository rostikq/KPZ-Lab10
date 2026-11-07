package io.github.rostikq;


import io.github.rostikq.task1.*;
import io.github.rostikq.task2.*;
import io.github.rostikq.task3.Waybill;
import io.github.rostikq.task3.WaybillBuilder;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ РОБОТИ СИСТЕМИ: СЛУЖБА ДОСТАВКИ «ПОСИЛКА+» ===\n");

        runTask1Demo();
        System.out.println();

        runTask2Demo();
        System.out.println();

        runTask3Demo();
    }

    private static void runTask1Demo() {
        System.out.println("--- ЗАВДАННЯ 1: Пакування відправлень (Abstract Factory) ---");
        PackingStation station = new PackingStation();

        station.packShipment("Звичайне відправлення #1", new StandardPackagingFactory());
        station.packShipment("Крихке відправлення #2", new FragilePackagingFactory());
        station.packShipment("Медикаменти (холодове) #3", new ColdPackagingFactory());

        // Новий тип розширення
        station.packShipment("Меблі (негабаритне) #4", new OversizedPackagingFactory());
    }

    private static void runTask2Demo() {
        System.out.println("--- ЗАВДАННЯ 2: Способи доставки (Factory Method) ---");
        String testAddress = "вул. Шевченка, 10";
        double testWeight = 4.5;

        DeliveryCreator courier = new CourierDeliveryCreator();
        courier.processDelivery(testAddress, testWeight);

        DeliveryCreator postamat = new PostamatDeliveryCreator();
        postamat.processDelivery(testAddress, testWeight);

        DeliveryCreator branch = new BranchDeliveryCreator();
        branch.processDelivery(testAddress, testWeight);

        // Новий спосіб доставки
        DeliveryCreator floor = new FloorDeliveryCreator();
        floor.processDelivery(testAddress, testWeight);
    }

    private static void runTask3Demo() {
        System.out.println("--- ЗАВДАННЯ 3: Оформлення накладної (Builder) ---");

        // 1. Повне формування
        try {
            Waybill customWaybill = new WaybillBuilder()
                    .setSender("ТОВ 'Агро-Світ'")
                    .setRecipient("Іван Петренко", "+380501112233")
                    .setWeight(12.5)
                    .setDeclaredValue(true)
                    .setCashOnDelivery(true)
                    .setInsurance(true)
                    .build();
            System.out.println("Результат: " + customWaybill);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 2. Типове формування
        try {
            Waybill docWaybill = WaybillBuilder.buildTypicalDocuments("Юридична фірма 'Право'", "Дмитра Коваль", "+380679998877");
            System.out.println("Результат: " + docWaybill);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // 3. Відтворення помилки валидації (без телефону отримувача)
        try {
            System.out.println("Спроба сформувати накладну без телефону отримувача...");
            Waybill invalidWaybill = new WaybillBuilder()
                    .setSender("ФОП Сидоренко")
                    .setRecipient("Олена", "")
                    .setWeight(2.0)
                    .build();
        } catch (IllegalStateException e) {
            // Очікуваний виняток
        }
    }
}