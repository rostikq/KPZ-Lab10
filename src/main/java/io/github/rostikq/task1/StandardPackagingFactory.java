package io.github.rostikq.task1;

public class StandardPackagingFactory implements PackagingFactory {
    @Override
    public Box createBox() {
        return () -> "Звичайна картонна коробка";
    }

    @Override
    public Filler createFiller() {
        return () -> "Паперовий наповнювач";
    }

    @Override
    public Label createLabel() {
        return () -> "Стандартна етикетка";
    }
}