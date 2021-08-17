package domain.banks;

import domain.Atm;
import domain.interfaces.AtmPrivateOperations;
import domain.interfaces.Bank;

public class TinkoffBank extends Atm implements Bank, AtmPrivateOperations {

    private static final String ATM_MANUFACTURER_NAME = "Diebold incorporated";
    private static final String BANK_NAME = "Tinkoff Bank";

    private int quantityBanknotes20;
    private int quantityBanknotes50;
    private int quantityBanknotes100;

    private int quantityBanknotesWithdraw20;
    private int quantityBanknotesWithdraw50;
    private int quantityBanknotesWithdraw100;

    public TinkoffBank(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
        super(quantityBanknotes20, quantityBanknotes50, quantityBanknotes100);
    }

    @Override
    public boolean privateWithdrawMoney(int sum) {
        final int banknotes20 = 20;
        final int banknotes50 = 50;
        final int banknotes100 = 100;
        boolean operation;

        int quantityAllBanknotes = banknotes20 * getQuantityBanknotes20()
                + banknotes50 * getQuantityBanknotes50()
                + banknotes100 * getQuantityBanknotes100();

        if (quantityAllBanknotes < sum || sum % 10 != 0 || sum == 0) {

            operation = false;
            System.out.println("\n" + new Exception("Not enough money"));

        } else {
            while (sum > 0 && getQuantityBanknotes100() > 0) {
                sum -= banknotes100;
                quantityBanknotes100--;

                quantityBanknotesWithdraw100++;
            }
            if (sum < 0) {
                sum += banknotes100;
                quantityBanknotes100++;
            }

            while (sum > 0 && getQuantityBanknotes50() > 0) {
                sum -= banknotes50;
                quantityBanknotes50--;

                quantityBanknotesWithdraw50++;
            }
            if (sum < 0) {
                sum += banknotes50;
                quantityBanknotes50++;
            }

            while (sum > 0 && getQuantityBanknotes20() > 0) {
                sum -= banknotes20;
                quantityBanknotes20--;

                quantityBanknotesWithdraw20++;
            }

            operation = true;
        }

        showWithdrawQuantityBanknotes(
                quantityBanknotesWithdraw20,
                quantityBanknotesWithdraw50,
                quantityBanknotesWithdraw100
        );

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
