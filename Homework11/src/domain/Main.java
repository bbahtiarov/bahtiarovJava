package domain;

import domain.banks.AlfaBank;
import domain.banks.IdeaBank;
import domain.banks.TechnoBank;
import domain.banks.TinkoffBank;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        chooseBank();

        Scanner scanner = new Scanner(System.in);
        verificationBank(scanner.nextLine());

    }

    private static void verificationBank(String nameBank) {
        Bank bank;

        switch (nameBank) {
            case "Alfa Bank" -> {
                bank = new AlfaBank(0, 0, 0);

                break;
            }
            case "Techno Bank" -> {
                bank = new TechnoBank(0, 0, 0);

                break;
            }
            case "Idea Bank" -> {
                bank = new IdeaBank(0, 0, 0);

                break;
            }
            case "Tinkoff Bank" -> {
                bank = new TinkoffBank(1, 1, 1);

                break;
            }
            default -> throw new IllegalStateException("Unexpected value: " + nameBank);
        }

        executeAtmOperation(bank);

    }

    private static void executeAtmOperation (Bank bank) {

        System.out.println(bank.getAtmManufacturerName());
        System.out.println(bank.getBankName());

        System.out.println("Введите количество денег для внесения в банкомат.");
        Scanner addAmountScanner = new Scanner(System.in);
        int inputAddAmount = addAmountScanner.nextInt();
        bank.addMoney(inputAddAmount);
        showAtmBalance(bank);

        System.out.println("Введите количество денег для снятия из банкомата.");
        Scanner wdAmountScanner = new Scanner(System.in);
        int inputWithdrawAmount = wdAmountScanner.nextInt();
        bank.withdrawMoney(inputWithdrawAmount);
        showAtmBalance(bank);

        if (bank instanceof TinkoffBank) {
            System.out.println("Введите количество денег для выдачи банкнот.");
            Scanner privateScanner = new Scanner(System.in);
            int inputPrivateAmount = privateScanner.nextInt();

            bank.privateWithdrawMoney(inputPrivateAmount);
            showQuantitiesBanknotes(bank);
        }

    }


    private static void chooseBank() {
        System.out.println(
                "Выберете банк, который хотите использовать:" + "\n"
                        + "Alfa Bank" + "\n"
                        + "Techno Bank" + "\n"
                        + "Idea Bank" + "\n"
                        + "Tinkoff Bank" + "\n"
        );
    }

    private static void showAtmBalance(Atm atm) {

        System.out.println( "Баланс: ");

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
