import java.util.Random;
import java.util.Scanner;

public class NoughtsAndCrosses {
    /*
    *        1, 2, 3, 4, 5, 6, 7, 8, 9
    *        [0][0], [0][2], [0][4]
    *        [1][0], [1][2], [1][4]
    *        [2][0], [2][2], [2][4]
    * */


    public static void main (String[] args) {
/*        // welcome user and get input
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Do you want to be X or O?");
        String userPiece = scan.nextLine();
        Character newPiece = userPiece.charAt(0);
        System.out.println(userPiece);
        System.out.println("The computer will go first");

        // Make Gameboard
        char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', '_', '|', ' '}};*/
        //printGameboard(gameBoard);
        //updateBoard(5, gameBoard, newPiece);
/*        computerMove(gameBoard, newPiece);
        playerMove(gameBoard, newPiece);
        computerMove(gameBoard, newPiece);
        playerMove(gameBoard, newPiece);*/

        Scanner scan = new Scanner(System.in);
/*        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Do you want to be X or O?");
        String userPiece = scan.nextLine();
        Character newPiece = userPiece.charAt(0);
        //System.out.println(userPiece);
        System.out.println("The computer will go first");

        // Make Gameboard
        char[][] gameBoard = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', '_', '|', ' '}};*/
        char[][] gameBoard = {{'_', '|', '_', '|', '_'},
                              {'_', '|', '_', '|', '_'},
                              {' ', '|', '_', '|', ' '}};
        boolean gameOver = false;
        boolean playAgain = true;
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Do you want to be X or O?");
        String userPiece = scan.nextLine();
        Character newPiece = userPiece.charAt(0);
        System.out.println("The computer will go first");
        printGameboard(gameBoard);

        while (playAgain) {
            while (!gameOver) {
                computerMove(gameBoard, newPiece);
                gameOver = hasAnyoneWon(gameBoard);
                if (gameOver) {
                    System.out.println("The Computer Won");
                    break;
                }

                playerMove(gameBoard, newPiece);
                gameOver = hasAnyoneWon(gameBoard);
                if (gameOver) {
                    System.out.println("You Won");
                    break;
                }
            }

            //
            System.out.println("Do you want to play again? (Y or N)");
            String choice = scan.nextLine();
            switch (choice) {
                case "y":
                case "Y":
                    playAgain = true;
                    resetGameboard(gameBoard);
                    gameOver = false;
                    printGameboard(gameBoard);
                    break;
                case "n":
                case "N":
                    System.out.println("See you later, alligator!");
                    playAgain = false;
                    break;
                default:
                    break;
            }

        }
        
    }

    public static void printGameboard (char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void updateBoard (int position, char [][] gameBoard, Character newPiece) {

        switch (position) {
            case 1:
                gameBoard[0][0] = newPiece;
                printGameboard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = newPiece;
                printGameboard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = newPiece;
                printGameboard(gameBoard);
                break;
            case 4:
               gameBoard[1][0] = newPiece;
               printGameboard(gameBoard);
               break;
            case 5:
                gameBoard[1][2] = newPiece;
                printGameboard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = newPiece;
                printGameboard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = newPiece;
                printGameboard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = newPiece;
                printGameboard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = newPiece;
                printGameboard(gameBoard);
                break;
            default:
                break;
        }
    }

    public static void playerMove (char [][] gameBoard, Character newPiece) {
        System.out.println("What is your next move? (1-9)");
        Scanner input = new Scanner(System.in);
        int position = input.nextInt();
        boolean result = validMoves(position, gameBoard);

        while (!result) {
            System.out.println("Sorry, that's an invalid move. Try again.");
            position = input.nextInt();
            result = validMoves(position, gameBoard);
        }

        System.out.println("You moved at: " + position);
        updateBoard(position, gameBoard, newPiece);
    }

    public static void computerMove (char [][] gameBoard, Character newPiece) {
        Random rand = new Random();
        char character;

        if (newPiece == 'X') {
            character = 'O';
        } else {
            character = 'X';
        }

        int comPosition = rand.nextInt(9) + 1;
        boolean result = validMoves(comPosition, gameBoard);

        while (!result) {
            comPosition = rand.nextInt();
            result = validMoves(comPosition, gameBoard);
        }

        System.out.println("Computer moved at: " + comPosition);
        updateBoard(comPosition, gameBoard, character);

    }

    public static boolean validMoves (int position, char [][] gameBoard) {
        switch (position) {
            case 1:
                if (gameBoard[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (gameBoard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameBoard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameBoard[2][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static boolean hasAnyoneWon (char [][] gameBoard) {

        // Horizontal Win Row 1
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("We have a winner");
            return true;
        }

        // Horizontal Win Row 2
        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O') {
            System.out.println("We have a winner");
            return true;
        }

        // Horizontal Win Row 3
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("We have a winner");
            return true;
        }

        // Vertical Win Row 1
        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("We have a winner");
            return true;
        }

        // Vertical Win Row 2
        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') {
            System.out.println("We have a winner");
            return true;
        }

        // Vertical Win Row 3
        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("We have a winner");
            return true;
        }

        // Diagonal Win 1
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("We have a winner");
            return true;
        }

        // Diagonal Win 2
        if (gameBoard[0][4] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("We have a winner");
            return true;
        }
        if (gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' &&
            gameBoard[1][0] != '_' && gameBoard[1][2] != '_' && gameBoard[1][4] != '_' &&
            gameBoard[2][0] != ' ' && gameBoard[2][2] != '_' && gameBoard[2][4] != ' ') {
            System.out.println("It's a tie");
            return true;
        }
        return false;
    }

    public static void resetGameboard (char [][] gameBoard) {
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = '_';
        gameBoard[2][4] = ' ';
    }
}
