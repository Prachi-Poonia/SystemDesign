package DesignPatterns.Creational.Builder;

//ConcreteBuilder
public class GamingComputerBuilder implements ComputerBuilder{
    private Computer computer;

    public GamingComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildCPU(){
        computer.setCpu("Gaming CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRam("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}
