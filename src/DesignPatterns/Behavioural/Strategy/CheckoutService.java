package DesignPatterns.Behavioural.Strategy;

public class CheckoutService {
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        PaymentStrategy upiPayment = new UpiPayment("alice@abc");
        cart.setPaymentStrategy(upiPayment);
        cart.checkout(500);

        //switch payment methods
        PaymentStrategy cardPayment = new CreditCardPayment("ABC56789");
        cart.setPaymentStrategy(cardPayment);
        cart.checkout(1000);
    }
}
