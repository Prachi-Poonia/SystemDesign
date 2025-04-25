package DesignPatterns.Creational.FactoryPattern;

public class NotificationFactory {
    public Notification planNotification(String channel){
        if(channel.isEmpty() || channel == null){
            return null;
        }
        else if(channel.equals("SMS")){
            return new SMS();
        }
        else if(channel.equals("Email")){
            return new Email();
        }
        else{
            throw new IllegalArgumentException("Unknown channel");
        }
    }
}
