package domain;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] arg) {

        Atm atm = new Atm(0, 0, 0);

        System.out.println("Введите количество денег для внесения в банкомат.");
        Scanner addAmountScanner = new Scanner(System.in);
        int inputAddAmount = addAmountScanner.nextInt();
        atm.addMoney(inputAddAmount);

        System.out.println("Введите количество денег для снятия из банкомата.");
        Scanner wdAmountScanner = new Scanner(System.in);
        int inputWithdrawAmount = wdAmountScanner.nextInt();
        atm.withdrawMoney(inputWithdrawAmount);

    }

}
