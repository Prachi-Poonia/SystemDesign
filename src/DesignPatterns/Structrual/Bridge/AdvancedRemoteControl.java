package DesignPatterns.Structrual.Bridge;

public class AdvancedRemoteControl extends RemoteControl{

    public AdvancedRemoteControl(Device device){
        super(device);
    }

    public void turnOnDevice(){
        device.turnOn();
    }

    public void turnOffDevice(){
        device.turnOff();
    }

    public void mute(){
        System.out.println("Device is muted");
    }
}
