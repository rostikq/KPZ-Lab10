package io.github.rostikq.task1;

public class FragilePackagingFactory implements PackagingFactory {
    @Override
    public Box createBox() {
        return () -> "Посилена коробка з гофрокартону";
    }

    @Override
    public Filler createFiller() {
        return () -> "Пухирчаста плівка (амортизатор)";
    }

    @Override
    public Label createLabel() {
        return () -> "Маніпуляційний знак 'Крихке / Обережно'";
    }
}