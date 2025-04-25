package DesignPatterns.Creational.Builder;

public class Director {
    public void construct(ComputerBuilder builder){
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}
