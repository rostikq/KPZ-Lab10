package io.github.rostikq.task1;

public class OversizedPackagingFactory implements PackagingFactory {
    @Override
    public Box createBox() {
        return () -> "Дерев'яний каркас (негабаритний)";
    }

    @Override
    public Filler createFiller() {
        return () -> "Щільний технічний пінополістирол";
    }

    @Override
    public Label createLabel() {
        return () -> "Етикетка 'НЕГАБАРИТНИЙ ВАНТАЖ'";
    }
}