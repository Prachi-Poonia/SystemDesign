package Practice.Easy.VendingMachine;

public class ReturnChangeState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.print("Product already selected, returning change");
    }

    @Override
    public void insertNote(Note note) {
        System.out.print("Payment already successful, returning change");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.print("Payment already successful, returning change");
    }

    @Override
    public void dispenseProduct() {
        System.out.print("Product already dispensed, returning change");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        if(change > 0){
            System.out.println("Please collect you change: "+ change);
        }
        else{
            System.out.println("No change to return");
        }
        vendingMachine.resetPayment();
        vendingMachine.resetProduct();
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}
