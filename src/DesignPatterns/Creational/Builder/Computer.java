package DesignPatterns.Creational.Builder;

//Product
public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram){
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void displayInfo() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }
}
