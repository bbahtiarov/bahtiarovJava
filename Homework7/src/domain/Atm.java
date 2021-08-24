package domain;

public class Atm {

    private final int quantityBanknotes20;
    private final int quantityBanknotes50;
    private final int quantityBanknotes100;
    private final int[] nominalBanknotes = {20, 50, 100}; //массив имеющихся купюр
    private int[] quantitiesBanknotes;

    public Atm(int quantityBanknotes20, int quantityBanknotes50, int quantityBanknotes100) {
        this.quantityBanknotes20 = quantityBanknotes20;
        this.quantityBanknotes50 = quantityBanknotes50;
        this.quantityBanknotes100 = quantityBanknotes100;
    }

    public int[] getNominalBanknotes() {
        return nominalBanknotes;
    }

    public int[] getQuantitiesBanknotes() {
        return quantitiesBanknotes;
    }

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

    public int[] withdrawMoney(int sum) {

        final int[] quantitiesWithdrawBanknotes = {0, 0, 0};

        if (sum % 10 != 0 || sum == 0) {

            System.out.println("\n" + new Exception("Not enough money"));

        } else {

            for (int i = nominalBanknotes.length - 1; i >= 0; --i) {
                quantitiesWithdrawBanknotes[i] = sum / nominalBanknotes[i];
                quantitiesBanknotes[i] = quantitiesBanknotes[i] - quantitiesWithdrawBanknotes[i];
                sum = sum - nominalBanknotes[i] * quantitiesWithdrawBanknotes[i];
            }

        }

        return quantitiesWithdrawBanknotes;
    }

}