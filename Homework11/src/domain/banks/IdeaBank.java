package domain.banks;

import domain.Atm;
import domain.interfaces.Bank;

public class IdeaBank extends Atm implements Bank {

    private static final String ATM_MANUFACTURER_NAME = "Diebold incorporated";
    private static final String BANK_NAME = "Idea Bank";

    public IdeaBank(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
        super(quantityBanknotes20, quantityBanknotes50, quantityBanknotes100);
    }

    @Override
    public String getAtmManufacturerName() {
        return ATM_MANUFACTURER_NAME;
    }

    @Override
    public String getBankName() {
        return BANK_NAME;
    }
}
