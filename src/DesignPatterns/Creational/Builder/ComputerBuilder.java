package DesignPatterns.Creational.Builder;

//Builder
public interface ComputerBuilder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    Computer getResult();
}
