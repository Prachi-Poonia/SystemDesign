package DesignPatterns.Structrual.Bridge;

public class Radio implements Device{
    @Override
    public void turnOn(){
        System.out.println("Radio is tuned on");
    }

    @Override
    public void turnOff(){
        System.out.println("Radio is turned off");
    }
}
