import java.util.ArrayList;
import java.util.Random;

import javax.print.DocFlavor.STRING;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randArray = new ArrayList<Integer>();
        Random randMachine = new Random();
        for (int i = 0; i < 10; i++){
            int randNo = randMachine.nextInt(20);
            randArray.add(randNo);
        }
        return randArray;
    }

    public Character getRandomLetter() {
        Random randMachine = new Random();
            int randNo = randMachine.nextInt(122-97) + 97;
            char randLetter = (char)randNo;
        return randLetter;
    }

    public String generatePassword() {
        Random randMachine = new Random();
        String genPass = "";
        for (int i = 0; i < 8 ; i++){
            int randNo = randMachine.nextInt(126);
            char randLetter = (char)randNo;
            genPass += randLetter;
        }
        return genPass;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> randArray = new ArrayList<String>();
        Random randMachine = new Random();
        for (int i = 0; i < length ; i++){
            String newPass = "";
            for (int j = 0; j < 8 ; j++){
                int randNo = randMachine.nextInt(126);
                char randLetter = (char)randNo;
                newPass += randLetter;
            }
            randArray.add(newPass);
        }
        return randArray;
    }
    
}
