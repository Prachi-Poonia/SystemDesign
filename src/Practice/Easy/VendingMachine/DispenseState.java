package Practice.Easy.VendingMachine;

public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product selected, will be dispensed soon");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment successful, dispensing...");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment successful, dispensing...");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateProduct(product, vendingMachine.inventory.getQuantity(product) - 1);
        System.out.println("Dispensing " + vendingMachine.getSelectedProduct().getProductName());
        vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Please collect your dispensed product first");
    }
}
