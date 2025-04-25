package DesignPatterns.Creational.AbstractFactoryPattern;

//Concrete Factory
public class WindowsFactory implements GuiFactory{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }

    @Override
    public Checkbox creteCheckBox(){
        return new WindowsCheckbox();
    }
}
