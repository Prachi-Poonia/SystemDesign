package DesignPatterns.Creational.FactoryPattern;

public class Email implements Notification{
    @Override
    public void userNotification(){
        System.out.println("Email notification sent!");
    }
}
