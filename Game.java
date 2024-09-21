import java.util.ArrayList;
import java.util.Collections;

public class Game {
 Game(){
     System.out.println("""
             Hi, Welcome to the Number Guessing Game.
             I'm thinking of a number between 1 and 100.
             You have to guess the correct number.""");
 }


    static int attempts;
    static int randomNumber = (int) Math.round(Math.random()*100);
    static int totalAttempts;
    static boolean endOfGame;                // indicates when game is either won or lost
    static boolean levelSelected;            // indicates whether a difficulty level has been selected
    static ArrayList<Integer> scores = new ArrayList<>();
    static int highScore;

    static public void levelDifficulty(int difficulty) {


            if (difficulty == 1) {
                Game.totalAttempts = 10;
                System.out.println("""
                        You selected the 'Easy' difficulty level.
                        You have 10 tries.
                        Lets start""");
                Game.levelSelected = true;
            } else if (difficulty == 2) {
                Game.totalAttempts = 5;
                System.out.println("""
                        You selected the 'Medium' difficulty level.
                        You have 5 tries.
                        Lets start""");
                Game.levelSelected = true;
            } else if (difficulty == 3) {
                Game.totalAttempts = 3;
                System.out.println("""
                        You selected the 'Hard' difficulty level.
                        You have 3 tries.
                        Lets start""");
                Game.levelSelected = true;
            } else {
                System.out.println("Please choose between difficulty levels 'Easy','Medium' and 'Hard'");
                       newGame(1);   //causes the game to restart after invalid input

        }
    }

    static public void numberCheck(int number) {                 //  Checks whether the players guess is correct
       try {
           Game.attempts++;
           if (number == randomNumber) {
               scores.add(Game.attempts);
               Collections.sort(scores);
               Game.highScore = scores.get(0);
               Game.endOfGame = true;
               System.out.println("Congratulations, you got it right.\nIt took you " + Game.attempts + " attempt(s)\nYour high score is " + Game.highScore);
           } else if (number > 100 || number < 0) {
               System.out.println("Guess should be between 0 and 100");
           } else {
               if (number > randomNumber) {
                   System.out.println("Incorrect!. The number is less than " + number);
               } else {
                   System.out.println("Incorrect!. The number is greater than " + number);
               }
               Game.totalAttempts--;
               System.out.println("You have " + Game.totalAttempts + " tries left");

           }

           if (totalAttempts == 0) {
               System.out.println("Game Over! You've run out of tries\nThe number was " + Game.randomNumber);
               Game.endOfGame = true;
           }
       }catch (Exception e){
           System.out.println("NUmber input");
       }
    }

    static public void newGame(int option){
        Game.attempts = 0;
        Game.endOfGame = false;
        Game.levelSelected = false;
        randomNumber = (int) Math.round(Math.random()*100);
    }



}
