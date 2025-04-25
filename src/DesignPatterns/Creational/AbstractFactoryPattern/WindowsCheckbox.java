package DesignPatterns.Creational.AbstractFactoryPattern;

//Concrete Products
public class WindowsCheckbox implements Checkbox{
    public void paint(){
        System.out.println("You created a Windows checkbox!");
    }
}
