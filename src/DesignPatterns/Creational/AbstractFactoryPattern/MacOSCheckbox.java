package DesignPatterns.Creational.AbstractFactoryPattern;

//Concrete Products
public class MacOSCheckbox implements Checkbox{
    public void paint(){
        System.out.println("You created a Mac OS checkbox!");
    }
}
