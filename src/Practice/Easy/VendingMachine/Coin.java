package Practice.Easy.VendingMachine;

public enum Coin {
    PENNY(0.01),
    NICKLE(0.05),
    DIME(0.1),
    QUARTER(0.25);

    private final double value;

    Coin(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
