package DesignPatterns.Structrual.Adapter;

public class PaymentAdapter implements NewPaymentProcessor{
    private static final Double EXCHANGE_RATE = 83.0;

    @Override
    public void payInINR(String cardNumber, Double amountInINR){
        double amountInUSD = amountInINR/EXCHANGE_RATE;

        System.out.println("Adapter: Converting INR to USD...");
        System.out.printf("₹%.2f INR -> $%.2f USD%n", amountInINR, amountInUSD);

        OldPaymentProcessor oldPaymentProcessor = new OldPaymentProcessor(cardNumber,amountInUSD);
        oldPaymentProcessor.makePayment();
    }
}
