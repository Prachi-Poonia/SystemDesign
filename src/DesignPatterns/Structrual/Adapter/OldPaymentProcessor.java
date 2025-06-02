package DesignPatterns.Structrual.Adapter;

import javax.swing.plaf.PanelUI;

//Adaptee
public class OldPaymentProcessor {
    String cardNumber;
    Double amount;

    public OldPaymentProcessor(String cardNumber, Double amount){
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public void makePayment(){
        System.out.println("Old System: Processing payment...");
        System.out.println("Card: " + cardNumber + ", Amount in USD: $" + amount);
    }
}
