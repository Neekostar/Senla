package Task2_CurrencyConverter;

import java.util.Scanner;

/*
Создай консольное приложение, которое запрашивает у пользователя сумму в одной валюте и конвертирует её в другие валюты
по фиксированному количеству обменных курсов. Курсы обмена валюты задавать в виде чисел с плавающей точкой.
Курсы можно задать внутри кода программы как константы или один раз запрашивать при запуске программы и потом
использовать их в течение всей ее работы. Пяти валют будет достаточно для реализации.
*/

public class CurrencyConverter {
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_RUB = 74.0;
    private static final double USD_TO_GBP = 0.76;
    private static final double USD_TO_JPY = 110.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму в долларах США: ");
        double amountInUSD = scanner.nextDouble();

        System.out.println("Сумма в евро: " + convert(amountInUSD, USD_TO_EUR));
        System.out.println("Сумма в рублях: " + convert(amountInUSD, USD_TO_RUB));
        System.out.println("Сумма в фунтах стерлингов: " + convert(amountInUSD, USD_TO_GBP));
        System.out.println("Сумма в йенах: " + convert(amountInUSD, USD_TO_JPY));
    }

    private static double convert(double amount, double rate) {
        return amount * rate;
    }
}
