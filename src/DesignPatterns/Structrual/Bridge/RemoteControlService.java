package DesignPatterns.Structrual.Bridge;

public class RemoteControlService {
    public static void main(String[] args){
        RemoteControl remoteControl = new BasicRemoteControl(new TV());
        remoteControl.turnOnDevice();
        remoteControl.turnOffDevice();

        RemoteControl remoteControl1 = new AdvancedRemoteControl(new Radio());
        remoteControl1.turnOnDevice();
        remoteControl1.turnOffDevice();
    }
}
