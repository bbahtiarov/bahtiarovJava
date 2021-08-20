package domain;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] arg) {

        Atm atm = new Atm(0, 0, 0);

        System.out.println("Введите количество денег для внесения в банкомат.");
        Scanner addAmountScanner = new Scanner(System.in);
        int inputAddAmount = addAmountScanner.nextInt();
        atm.addMoney(inputAddAmount);
        showAtmBalance(atm);

        System.out.println("Введите количество денег для снятия из банкомата.");
        Scanner wdAmountScanner = new Scanner(System.in);
        int inputWithdrawAmount = wdAmountScanner.nextInt();
        atm.withdrawMoney(inputWithdrawAmount);
        showQuantitiesBanknotes(atm);

    }

    private static void showAtmBalance(Atm atm) {

        for (int i = 0; i < atm.getQuantitiesBanknotes().length; i++) {

            System.out.printf(
                    "Номинал в %d руб. = %d шт.\n",
                    atm.getNominalBanknotes()[i],
                    atm.getQuantitiesBanknotes()[i]
            );

        }
    }

    private static void showQuantitiesBanknotes(Atm atmTest) {

        for (int i = 0; i < atmTest.getNominalBanknotes().length; i++)
        {

            if (atmTest.getQuantitiesWithdrawBanknotes()[i] == 0)
            {
                continue;
            }

            System.out.print(
                    "Выдано " + atmTest.getQuantitiesWithdrawBanknotes()[i]
                            + " купюр номинала "
                            + atmTest.getNominalBanknotes()[i] + "\n"
            );

        }

    }

}
