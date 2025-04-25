package DesignPatterns.Creational.AbstractFactoryPattern;

//Concrete Products
public class MacOSButton implements Button{
    public void paint(){
        System.out.println("You created a Mac OS button!");
    }
}
