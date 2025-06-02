package Practice.Easy.VendingMachine;

public class IdleState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.inventory.isAvailable(product)){
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setCurrentState(vendingMachine.getReadyState());
            System.out.println("Selected product : " + product.getProductName());
        }
        else{
            System.out.println("Selected product is currently not available");
        }
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select a product first");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first and make payment");
    }

    @Override
    public void returnChange() {
        System.out.println("No change to return");
    }
}
