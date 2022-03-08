import java.util.ArrayList;
import java.util.Random;
public class PuzzlingTest {
public static void main(String[] args) {

    PuzzleJava generator = new PuzzleJava();
    ArrayList<Integer> randomRolls = generator.getTenRolls();
    System.out.println(randomRolls);
//..
// Write your other test cases here.
//..
    Character randomLetters = generator.getRandomLetter();
    System.out.println(randomLetters);

    String randomPass = generator.generatePassword();
    System.out.println(randomPass);

    ArrayList<String> newmPassSet = generator.getNewPasswordSet(9);
    System.out.println(newmPassSet);
}
}