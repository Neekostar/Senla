package Task1_Hangman;

import java.util.Scanner;
import java.util.Random;

/*
Реализуй игру «Виселица», где игрок пытается угадать слово, вводя одну букву за раз.
Если буква отсутствует в слове, то игрок теряет жизнь.
Игра заканчивается, когда игрок угадывает слово или теряет все жизни.
Слово для отгадывания выбирать случайно из списка слов-констант внутри программы.
После каждой введенной буквы выводить в консоль загадываемое слово с пропусками букв и сообщение о том,
сколько жизней осталось. Рисовать в консоли человечка на виселице как иллюстрацию количества жизней
(как это обычно бывает в «Виселице») не обязательно, но будет приветствоваться.
*/

public class Hangman {
    private static final String[] WORDS = {"BREAKFAST", "MORNING", "WATERMELON", "FUTURE", "PINEAPPLE"};
    private static final int MAX_LIVES = 6;

    public static void main(String[] args) {
        Random random = new Random();
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
        int lives = MAX_LIVES;
        Scanner scanner = new Scanner(System.in);

        while (lives > 0 && String.valueOf(guessedWord).contains("_")) {
            System.out.println("Загаданное слово: " + String.valueOf(guessedWord));
            System.out.println("Осталось жизней: " + lives);
            System.out.print("Введите букву: ");
            char guessedLetter = scanner.next().toUpperCase().charAt(0);

            System.out.println("================================================================");

            boolean isCorrectGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    isCorrectGuess = true;
                }
            }

            if (!isCorrectGuess) {
                lives--;
            }
        }

        if (lives > 0) {
            System.out.println("Поздравляем, вы угадали слово: " + wordToGuess);
        } else {
            System.out.println("К сожалению, вы проиграли. Загаданное слово было: " + wordToGuess);
        }
    }
}
