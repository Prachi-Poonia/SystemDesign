package DesignPatterns.Structrual.Bridge;

public class TV implements Device{
    @Override
    public void turnOn(){
        System.out.println("TV is tuned on");
    }

    @Override
    public void turnOff(){
        System.out.println("TV is turned off");
    }
}
