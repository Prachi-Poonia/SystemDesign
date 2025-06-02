package Practice.Easy.VendingMachine;

public interface VendingMachineState {
    void selectProduct(Product product);

    void insertNote(Note note);

    void insertCoin(Coin coin);

    void dispenseProduct();

    void returnChange();

}
