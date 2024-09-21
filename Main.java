import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Game();

            for (int i = 0; i < 100; i++) {
                try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("""
                        Please select the difficulty level
                        1. Easy (10 tries)
                        2. Medium (5 tries)
                        3. Hard (3 tries)
                        
                        Input level of difficulty:""");

                int difficultyLevel = scanner.nextInt();
                scanner.nextLine();
                Game.levelDifficulty(difficultyLevel);


                if (Game.levelSelected) {
                    for (int j = 0; j < 12; j++) {                  // Allows player to guess again

                        System.out.println("Enter Your Guess");
                        int guess = scanner.nextInt();
                        scanner.nextLine();
                        Game.numberCheck(guess);

                        if (Game.endOfGame) {
                            break;
                        }
                    }


                    System.out.println("Press any number for new game");
                    int newGameOption = scanner.nextInt();
                    scanner.nextLine();
                    Game.newGame(newGameOption);
                }

            }catch (Exception e){
                    System.out.println("Numbers Only!");
                }
        }
        }
    }
