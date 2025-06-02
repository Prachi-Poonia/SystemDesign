package DesignPatterns.Structrual.Adapter;

//Target Interface
public interface NewPaymentProcessor {
    void payInINR(String cardNumber, Double amount);
}
