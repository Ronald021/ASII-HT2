package gt.com.antiguaburger.antiguaburgerweb.controller;

import java.util.List;

public abstract class OrderBuilderDecorator {

    public abstract List<String> getDecoratorMenu(List<String> comida, List<String> option);
}
