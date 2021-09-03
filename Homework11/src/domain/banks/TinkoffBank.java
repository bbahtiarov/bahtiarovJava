package domain.banks;

import domain.Bank;

public class TinkoffBank extends Bank {

    private static final String ATM_MANUFACTURER_NAME = "Diebold incorporated";
    private static final String BANK_NAME = "Tinkoff Bank";

    public TinkoffBank(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
        super(quantityBanknotes20, quantityBanknotes50, quantityBanknotes100);
    }

    @Override
    public boolean privateWithdrawMoney(int sum) {
        boolean operation = true;
        int quantityAllBanknotes =
                20 * getQuantitiesBanknotes()[0]
                        + 50 * getQuantitiesBanknotes()[1]
                        + 100 * getQuantitiesBanknotes()[2];

        if (quantityAllBanknotes < sum || sum % 10 != 0 || sum == 0) {

            operation = false;
            System.out.println("\n" + new Exception("Not enough money"));

        } else {

            for (int i = getNominalBanknotes().length - 1; i >= 0; --i)
            {
                getQuantitiesWithdrawBanknotes()[i] = sum / getNominalBanknotes()[i];
                getQuantitiesBanknotes()[i] =
                        getQuantitiesBanknotes()[i] - getQuantitiesWithdrawBanknotes()[i];
                sum = sum - getNominalBanknotes()[i] * getQuantitiesWithdrawBanknotes()[i];
            }

        }

        return operation;
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
