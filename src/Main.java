import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    static String[] words = {"alpha", "beta", "charlie", "delta", "echo"};
    static ArrayList<Character> usedLetters = new ArrayList<Character>();
    static int lives = 6;
    static String newWord = getRandomWord(words);
    static String guessedWord;
    static boolean isPlaying = true;
    static boolean newGame = false;

    public static void main(String[] args)
    {
        linkStart();
    }

    private static void linkStart()
    {
        System.out.println(newWord);
        System.out.println("Welcome to the game of Hangman. You have 6 lives and you have to guess the word correctly");
        while(isPlaying) {
            if (newGame == true) {
                newWord = getRandomWord(words);
                System.out.println(newWord);
            }
            System.out.println("Enter a guess");
            char guess = getGuess();
            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter");
                newGame = false;
            }
            if (isAlreadyGuessed(guess)) {
                System.out.println("Please enter a different letter");
            } else {
                usedLetters.add(guess);
                guessedWord = missingLetters(newWord, usedLetters);
                System.out.println(guessedWord);
                newGame = false;
                if ()
                {

                }
            }
        }
    }
    private static String missingLetters(String word, ArrayList<Character> letters)
    {
        String filledInWord = "";
        for(int i = 0; i < word.length(); i++)
        {
            for(int j = 0; j < letters.size(); j++)
            {
                if(word.charAt(i) == letters.get(j))
                {
                    filledInWord += word.charAt(i);
                }
            }
            if(!(filledInWord.length() > i))
            {
                filledInWord += '*';
            }
        }
        return filledInWord;
    }

    private static String getRandomWord(String[] words)
    {
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        return words[index];
    }

    private static char getGuess()
    {
        Scanner scan = new Scanner(System.in);
        char guess = scan.nextLine().toLowerCase().charAt(0);
        return guess;
    }

    private static boolean isAlreadyGuessed(char guess)
    {
        for(int i = 0; i < usedLetters.size(); i++)
        {
            if (usedLetters.get(i) == guess) {
                return true;
            }
        }
        return false;
    }
}
