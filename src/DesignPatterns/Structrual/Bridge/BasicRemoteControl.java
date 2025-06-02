package DesignPatterns.Structrual.Bridge;

public class BasicRemoteControl extends RemoteControl{

    public BasicRemoteControl(Device device){
        super(device); // when you extend an abstract class, the child class must call the parent class's constructor — especially if the parent doesn't have a no-arg (default) constructor.
        //If you don't add this constructor inside BasicRemoteControl, Java won't know how to properly call RemoteControl's constructor,
        //because Java automatically tries to call super() (no-argument constructor) if you don't write super(...),
        //but RemoteControl doesn't have a no-argument constructor!
        //you must manually call super(device).
    }

    public void turnOnDevice(){
        device.turnOn();
    }

    public void turnOffDevice(){
        device.turnOff();
    }
}
