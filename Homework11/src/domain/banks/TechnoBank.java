package domain.banks;

import domain.Bank;

public class TechnoBank extends Bank {

    private static final String ATM_MANUFACTURER_NAME = "Diebold incorporated";
    private static final String BANK_NAME = "Techno Bank";

    public TechnoBank(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
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
