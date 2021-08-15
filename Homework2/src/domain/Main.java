package domain;

public class Main {

    static String INPUT_STRING= "Hello world!";

    public static void main(String[] arg) {

        getStringLength(INPUT_STRING);
        getStrings(INPUT_STRING);

        isIntegerTrue(7777);

        System.out.println(getMoneyAddition( 101));
    }

    private static void getStringLength(String string) {

        System.out.println("Длина сторки: " + string.length());

    }

    private static void getStrings(String string) {

        int halfStringLength = string.length() / 2;
        String[] stringParts = {
                string.substring(0, halfStringLength),
                string.substring(halfStringLength),
        };

        String firstString = stringParts[0];
        String secondString = stringParts[1];

        System.out.println("Первая строка: " + firstString
                + "\n" + "Вторая строка: " + secondString);

    }

    private static void isIntegerTrue (int integer) {

        int lastInteger = integer%10;

        if (lastInteger == 7) System.out.println("\n" + "good, " + lastInteger);
        else System.out.println("\n" + "not yet, " + lastInteger);

    }

    private static String getMoneyAddition(int num) {

        int preLastDigit = num % 100 / 10;

        if (preLastDigit == 1) {
            return "\n" + num + " рублей";
        }

        return switch (num % 10) {
            case 1 -> "\n" + num + " рубль";
            case 2, 3, 4 -> "\n" + num + " рубля";
            default -> "\n" + num + " рублей";
        };

    }

}
