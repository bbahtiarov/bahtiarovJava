package domain;

import domain.banks.AlfaBank;
import domain.banks.IdeaBank;
import domain.banks.TechnoBank;
import domain.banks.TinkoffBank;
import domain.interfaces.Bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        chooseBank();

        Scanner scanner = new Scanner(System.in);
        verificationBank(scanner.nextLine());

    }

    private static void verificationBank(String nameBank) {

        switch (nameBank) {
            case "Alfa Bank" -> {
                AlfaBank alfaBank = new AlfaBank(0, 0, 0);

                fetchBankName(alfaBank);
                executeAtmOperation(alfaBank);
                break;
            }
            case "Techno Bank" -> {
                TechnoBank technoBank = new TechnoBank(0, 0, 0);

                fetchBankName(technoBank);
                executeAtmOperation(technoBank);
                break;
            }
            case "Idea Bank" -> {
                IdeaBank ideaBank = new IdeaBank(0, 0, 0);

                fetchBankName(ideaBank);
                executeAtmOperation(ideaBank);
                break;
            }
            case "Tinkoff Bank" -> {
                TinkoffBank tinkoffBank = new TinkoffBank(0, 0, 0);

                fetchBankName(tinkoffBank);
                executeAtmOperation(tinkoffBank);

                System.out.println("Введите количество денег для выдачи банкнот.");
                Scanner wdAmountScanner = new Scanner(System.in);
                int inputWithdrawAmount = wdAmountScanner.nextInt();
                tinkoffBank.privateWithdrawMoney(inputWithdrawAmount);
                break;
            }
        }

    }

    private static void executeAtmOperation (Atm atm) {

        System.out.println(atm.getAtmManufacturerName());

        System.out.println("Введите количество денег для внесения в банкомат.");
        Scanner addAmountScanner = new Scanner(System.in);
        int inputAddAmount = addAmountScanner.nextInt();
        atm.addMoney(inputAddAmount);

        System.out.println("Введите количество денег для снятия из банкомата.");
        Scanner wdAmountScanner = new Scanner(System.in);
        int inputWithdrawAmount = wdAmountScanner.nextInt();
        atm.withdrawMoney(inputWithdrawAmount);

    }

    private static void fetchBankName(Bank bank) {

        System.out.println(bank.getBankName());

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

}
