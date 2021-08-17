package domain;

import domain.interfaces.AtmBaseOperations;
import domain.interfaces.AtmManufacturer;

public abstract class Atm implements AtmManufacturer, AtmBaseOperations {

    private final int banknotes20 = 20;
    private final int banknotes50 = 50;
    private final int banknotes100 = 100;

    private int quantityBanknotes20;
    private int quantityBanknotes50;
    private int quantityBanknotes100;
    private boolean operation;

    public Atm(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
        this.quantityBanknotes20 = quantityBanknotes20;
        this.quantityBanknotes50 = quantityBanknotes50;
        this.quantityBanknotes100 = quantityBanknotes100;
    }

    public int getQuantityBanknotes20() {
        return quantityBanknotes20;
    }

    public int getQuantityBanknotes50() {
        return quantityBanknotes50;
    }

    public int getQuantityBanknotes100() {
        return quantityBanknotes100;
    }

    @Override
    public abstract String getAtmManufacturerName();

    @Override
    public boolean addMoney(int sum) {

        if (sum % 10 != 0 || sum == 0) {
            operation = false;

        } else {
            while (sum > 0) {
                sum -= banknotes100;
                quantityBanknotes100++;
            }
            if (sum < 0) {
                sum += banknotes100;
                quantityBanknotes100--;
            }
            while (sum > 0) {
                sum -= banknotes50;
                quantityBanknotes50++;
            }
            if (sum < 0) {
                sum += banknotes50;
                quantityBanknotes50--;
            }
            while (sum > 0) {
                sum -= banknotes20;
                quantityBanknotes20++;
            }
            operation = true;
        }

        showQuantityBanknotes(
                quantityBanknotes20,
                quantityBanknotes50,
                quantityBanknotes100
        );
        return operation;
    }

    @Override
    public boolean withdrawMoney(int sum) {
        int quantityAllBanknotes = banknotes20 * quantityBanknotes20
                + banknotes50 * quantityBanknotes50
                + banknotes100 * quantityBanknotes100;

        if (quantityAllBanknotes < sum || sum % 10 != 0 || sum == 0) {
            operation = false;
            System.out.println("\n" + new Exception("Not enough money"));
        } else {
            while (sum > 0 && quantityBanknotes100 > 0) {
                sum -= banknotes100;
                quantityBanknotes100--;

            }
            if (sum < 0) {
                sum += banknotes100;
                quantityBanknotes100++;
            }

            while (sum > 0 && quantityBanknotes50 > 0) {
                sum -= banknotes50;
                quantityBanknotes50--;

            }
            if (sum < 0) {
                sum += banknotes50;
                quantityBanknotes50++;
            }

            while (sum > 0 && quantityBanknotes20 > 0) {
                sum -= banknotes20;
                quantityBanknotes20--;

            }

            operation = true;
        }

        showQuantityBanknotes(
                quantityBanknotes20,
                quantityBanknotes50,
                quantityBanknotes100
        );

        return operation;
    }

    public void showWithdrawQuantityBanknotes(
            int amountBanknotes20,
            int amountBanknotes50,
            int amountBanknotes100
    ) {
        System.out.println(
                "Issued banknotes" + "\n"
                        + "banknotes 20: " + amountBanknotes20 + "\n"
                        + "banknotes 50: " + amountBanknotes50 + "\n"
                        + "banknotes 100: " + amountBanknotes100
        );
    }

    private void showQuantityBanknotes(
            int amountBanknotes20,
            int amountBanknotes50,
            int amountBanknotes100
    ) {
        System.out.println(
                "Balance banknotes in bank" + "\n"
                        + "banknotes 20: " + amountBanknotes20 + "\n"
                        + "banknotes 50: " + amountBanknotes50 + "\n"
                        + "banknotes 100: " + amountBanknotes100
        );
    }


}
