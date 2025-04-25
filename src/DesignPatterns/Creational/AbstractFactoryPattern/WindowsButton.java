package DesignPatterns.Creational.AbstractFactoryPattern;

//Concrete Products
public class WindowsButton implements Button{
    public void paint(){
        System.out.println("You created a Windows button!");
    }
}
