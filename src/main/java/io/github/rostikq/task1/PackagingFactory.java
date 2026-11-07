package io.github.rostikq.task1;

public interface PackagingFactory {
    Box createBox();
    Filler createFiller();
    Label createLabel();
}