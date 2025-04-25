package DesignPatterns.Creational.Builder;

public class ComputerService {
    public static void main(String[] args){
        GamingComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        Director computerDirector = new Director();
        computerDirector.construct(gamingComputerBuilder);
        Computer gamingComputer = gamingComputerBuilder.getResult();
        gamingComputer.displayInfo();
    }
}
