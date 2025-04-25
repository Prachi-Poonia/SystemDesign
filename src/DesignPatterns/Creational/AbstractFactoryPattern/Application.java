package DesignPatterns.Creational.AbstractFactoryPattern;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GuiFactory factory){
        button = factory.createButton();
        checkbox = factory.creteCheckBox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
