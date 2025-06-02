package Practice.Easy.VendingMachine;

public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected, please make payment");
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        if(checkPaymentStatus()){
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        if(checkPaymentStatus()){
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first");
    }

    private boolean checkPaymentStatus(){
        return vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice();
    }
}
