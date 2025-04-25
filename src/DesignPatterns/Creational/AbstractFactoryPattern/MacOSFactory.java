package DesignPatterns.Creational.AbstractFactoryPattern;

//Concrete Factory
public class MacOSFactory implements GuiFactory{
    @Override
    public Button createButton(){
        return new MacOSButton();
    }

    @Override
    public Checkbox creteCheckBox(){
        return new MacOSCheckbox();
    }
}
