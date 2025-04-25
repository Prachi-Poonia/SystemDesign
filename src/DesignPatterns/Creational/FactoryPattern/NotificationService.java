package DesignPatterns.Creational.FactoryPattern;

import java.util.Scanner;

public class NotificationService {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String channel = scn.nextLine();
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.planNotification(channel);
        notification.userNotification();
    }
}
