package io.github.rostikq.task1;

public class ColdPackagingFactory implements PackagingFactory {
    @Override
    public Box createBox() {
        return () -> "Термобокс з пінопласту";
    }

    @Override
    public Filler createFiller() {
        return () -> "Акумулятори холоду (латексні елементи)";
    }

    @Override
    public Label createLabel() {
        return () -> "Холодова етикетка ' t: +2..+8°C '";
    }
}