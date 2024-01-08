import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

class Hangman {
    private String[] Words = {"Ahmad", "Adurrehman", "Talha", "Wali", "Moeez", "Muawwaz", "John", "Muddasir","sirAfeef"};
    private StringBuilder GuessedWord;
    private String ToGuess;
    private double AttemptsLeft;
    private int Warnings;
    public Hangman() {
        Random Ran = new Random();
        ToGuess = Words[Ran.nextInt(Words.length)];
        ToGuess = ToGuess.toLowerCase();
        GuessedWord = new StringBuilder("_".repeat(ToGuess.length()));
        AttemptsLeft = ToGuess.length() * 1.5;
        AttemptsLeft = Math.round(AttemptsLeft);
        Warnings = 4;
    }
    public void Play() {
        Scanner sc = new Scanner(System.in);
        StringBuilder guessedLetters = new StringBuilder();     //track for guessed letters

        while (AttemptsLeft > 0 && !GuessedWord.toString().equals(ToGuess)) {
            System.out.println("AVAILABLE OPTION LETTERS");
            for (char cha = 'a'; cha <= 'z'; cha++) {
                if (guessedLetters.indexOf(String.valueOf(cha)) == -1) {
                    System.out.print(cha + " ");
                }
            }
            System.out.println();
            System.out.println("GUESS THE WORD");
            System.out.println("REMAINING ATTEMPTS ARE " + AttemptsLeft);
            System.out.println("GUESS THE LETTER ");
            System.out.println(GuessedWord);
            char alphabet = sc.next().charAt(0);

            if (!Character.isLowerCase(alphabet)) {
                if (Warnings > 0) {
                    Warnings--;
                    System.out.println("INVALID INPUT. YOU HAVE " + Warnings + " WARNINGS LEFT.");
                } else {
                    AttemptsLeft--;
                    System.out.println("YOU LOSE A GUESS.");
                }
            } else if (guessedLetters.indexOf(String.valueOf(alphabet)) != -1) { //If the letter has already been guessed
                if (Warnings > 0) {
                    Warnings--;
                    System.out.println("YOU HAVE ALREADY GUESSED THAT LETTER. YOU HAVE" + Warnings + " WARNINGS LEFT.");
                } else {
                    AttemptsLeft--;
                    System.out.println("YOU HAVE ALREADY GUESSED THAT LETTER.YOU LOSE A GUESS.");
                }
            } else {
                guessedLetters.append(alphabet);

                boolean found = false;
                for (int i = 0; i < ToGuess.length(); i++) {
                    if (ToGuess.charAt(i) == alphabet) {
                        GuessedWord.setCharAt(i, alphabet);
                        found = true;
                    }
                }

                if (!found) {
                    AttemptsLeft--;
                }
            }
        }
        if (GuessedWord.toString().equals(ToGuess)) {
            System.out.println("YOU WON: THE GIVEN WORD IS " + ToGuess);
        } else {
            System.out.println("YOU LOSE; THE GIVEN WORD WAS " + ToGuess);
        }
    }
}
public class Hangmano {
    public static void main(String[] args) {
        System.out.println("WELCOME TO GAME : ");
        Hangman game = new Hangman();
        game.Play();
    }
}
