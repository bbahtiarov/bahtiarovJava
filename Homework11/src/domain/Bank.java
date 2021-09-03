package domain;

public abstract class Bank extends Atm {

    public Bank(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
        super(quantityBanknotes20, quantityBanknotes50, quantityBanknotes100);
    }

    public abstract String getBankName();

}
