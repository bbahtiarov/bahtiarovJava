package domain;

import domain.interfaces.AtmBaseOperations;
import domain.interfaces.AtmPrivateOperations;

public abstract class Atm implements AtmBaseOperations, AtmPrivateOperations {

    private final int quantityBanknotes20;
    private final int quantityBanknotes50;
    private final int quantityBanknotes100;

    private final int[] nominalBanknotes = {20, 50, 100}; //массив имеющихся купюр
    private final int[] quantitiesWithdrawBanknotes = {0, 0, 0};
    private int[] quantitiesBanknotes;

    public Atm(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
        this.quantityBanknotes20 = quantityBanknotes20;
        this.quantityBanknotes50 = quantityBanknotes50;
        this.quantityBanknotes100 = quantityBanknotes100;
    }

    public int[] getNominalBanknotes() {
        return nominalBanknotes;
    }

    public int[] getQuantitiesWithdrawBanknotes() {
        return quantitiesWithdrawBanknotes;
    }

    public int[] getQuantitiesBanknotes() {
        return quantitiesBanknotes;
    }

    public abstract String getAtmManufacturerName();

    @Override
    public boolean addMoney(int sum) {

        boolean operation = true;

        if (sum % 10 != 0 || sum == 0) {

            operation = false;
            System.out.println("\n" + new Exception("Incorrect sum"));

        } else {

            quantitiesBanknotes = new int[]
                    {
                            quantityBanknotes20,
                            quantityBanknotes50,
                            quantityBanknotes100
                    };

            int index = nominalBanknotes.length - 1;

            while (index != -1) {
                quantitiesBanknotes[index] = quantitiesBanknotes[index] + (sum / nominalBanknotes[index]);
                sum %= nominalBanknotes[index];
                index--;
            }

        }

        return operation;
    }

    @Override
    public boolean withdrawMoney(int sum) {

        boolean operation = true;
        int quantityAllBanknotes =
                20 * quantitiesBanknotes[0]
                        + 50 * quantitiesBanknotes[1]
                        + 100 * quantitiesBanknotes[2];

        if (quantityAllBanknotes < sum || sum % 10 != 0 || sum == 0) {

            operation = false;
            System.out.println("\n" + new Exception("Not enough money"));

        } else {

            int index = nominalBanknotes.length - 1;

            while (index != -1) {
                quantitiesBanknotes[index] = quantitiesBanknotes[index] - (sum / nominalBanknotes[index]);
                sum %= nominalBanknotes[index];
                index--;
            }

        }

        return operation;

    }

    @Override
    public boolean privateWithdrawMoney(int sum) {
        return false;
    }
}
