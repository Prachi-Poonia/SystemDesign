package DesignPatterns.Structrual.Bridge;

//Abstraction -> made an abstract class because we want to store reference to device object and to keep some common code
//which interfaces don't allow
abstract class RemoteControl {
    protected Device device;  // bridge

    public RemoteControl(Device device){
        this.device = device;   //common code, interface does not allow you to create constructors
    }

    public abstract void turnOnDevice();
    public abstract void turnOffDevice();
}
