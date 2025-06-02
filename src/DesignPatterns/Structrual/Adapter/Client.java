package DesignPatterns.Structrual.Adapter;

public class Client {
    public static void main(String[] args){
        PaymentAdapter gateway = new PaymentAdapter();
        gateway.payInINR("9876-5432-1098-7654", 8300.00);
    }
}
