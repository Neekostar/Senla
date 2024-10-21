package Task3_PasswordGenerator;

import java.util.Random;
import java.util.Scanner;

/*
Напиши программу, которая генерирует случайный безопасный пароль длиной от 8 до 12 символов.
Пароль должен содержать заглавные и строчные буквы, цифры и специальные символы.
Предоставь пользователю возможность выбрать длину пароля.
*/

public class PasswordGenerator {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину желаемого пароля (от 8 до 12): ");
        int length = scanner.nextInt();

        if (length < 8 || length > 12) {
            System.out.println("Неправильная длина. Пароль должен быть от 8 до 12 символов.");
        } else {
            System.out.println("Сгенерированный пароль: " + generatePassword(length));
        }
    }

    private static String generatePassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Добавляется как минимум по одному обязательному символу для выполнения условия
        password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
        password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Оставшиеся символы выбираются случайно из всех возможных
        String allCharacters = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        Random random = new Random();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
