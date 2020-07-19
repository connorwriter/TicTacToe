package tictactoe;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int[][] table = new int[3][3];

    // states of play
    static boolean xThree = false;
    static boolean oThree = false;
    static boolean turnOfX = true;
    static boolean gameOngoing = true;

    static int xCount = 0;
    static int oCount = 0;
    static int spaceCount = 0;
    static int first = 0;
    static int second = 0;
    static int x = 88;
    static int o = 79;


    public static void main(String[] args) {
        newGame();
        printBoard();

        while (gameOngoing == true) {
            implementNextMove();
            printBoard();
            checkIfGameFinished();
        }
    }

    public static void newGame() {
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                table[i][j] = 32;
            }
        }
    }

    public static void printBoard() {

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == 88) {
                    System.out.print("X ");
                } else if (table[i][j] == 79) {
                    System.out.print("O ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    public static void getGameInProgress() {

        String getBoard = scanner.nextLine();
        int stringReader = 0;

        // populate 'table' using 'getBoard'
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                table[i][j] = getBoard.charAt(stringReader);
                ++stringReader;
            }
        }
    }

    public static boolean containsNumbers(String x) {
        boolean containsNumbers = false;
        if (x.charAt(0) == '1') {
            containsNumbers = true;
        } else if (x.charAt(0) == '2') {
            containsNumbers = true;
        } else if (x.charAt(0) == '3') {
            containsNumbers = true;
        } else if (x.charAt(0) == '4') {
            containsNumbers = true;
        } else if (x.charAt(0) == '5') {
            containsNumbers = true;
        } else if (x.charAt(0) == '6') {
            containsNumbers = true;
        } else if (x.charAt(0) == '7') {
            containsNumbers = true;
        } else if (x.charAt(0) == '8') {
            containsNumbers = true;
        } else if (x.charAt(0) == '9') {
            containsNumbers = true;
        } else if (x.charAt(0) == '0') {
            containsNumbers = true;
        }
        return containsNumbers;
    }

    public static void checkIfGameFinished() {

        xCount = 0;
        oCount = 0;
        spaceCount = 0;

        int row1 = table[0][0] + table [0][1] + table [0][2];
        int row2 = table[1][0] + table [1][1] + table [1][2];
        int row3 = table[2][0] + table [2][1] + table [2][2];

        int column1 = table[0][0] + table [1][0] + table [2][0];
        int column2 = table[0][1] + table [1][1] + table [2][1];
        int column3 = table[0][2] + table [1][2] + table [2][2];

        int diagonal1 = table[0][0] + table [1][1] + table [2][2];
        int diagonal2 = table[0][2] + table [1][1] + table [2][0];

        int[] possibilities = new int[]{row1, row2, row3, column1, column2, column3,
        diagonal1, diagonal2};

        // Check if there is a line of 3

        for (int i = 0; i < possibilities.length; i++) {
            if (possibilities[i] == 264) {
                xThree = true;
            } else if (possibilities[i] == 237) {
                oThree = true;
            }
        }

        for (int[] ints : table) {
            for (int j = 0; j < table.length; j++) {
                if (ints[j] == 88) {
                    ++xCount;
                } else if (ints[j] == 79) {
                    ++oCount;
                } else {
                    ++spaceCount;
                }
            }
        }

        if (xThree == false && oThree == false && spaceCount == 0) {
            System.out.println("Draw");
            gameOngoing = false;
        } else if (xThree == true && oThree == false) {
            System.out.println("X wins");
            gameOngoing = false;
        } else if (xThree == false && oThree == true) {
            System.out.println("O wins");
            gameOngoing = false;
        } else {
            System.out.println("Game ongoing");
            gameOngoing = true;
        }
    }

    public static void implementNextMove() {
        boolean moveSuccessful = false;

        while (moveSuccessful == false) {
            // Get user input
            System.out.println("Enter the coordinates:");

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                // System.out.println(input);

                if (containsNumbers(input)) {
                    String [] pieces = input.split(" ");

                    first = Integer.parseInt(pieces[0]);
                    second = Integer.parseInt(pieces[1]);

                    if (first != 1 && first != 2 && first != 3 ||
                            second != 1 && second != 2 && second != 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }

                    // System.out.println(first + " " + second);
                } else {
                    System.out.println("You should enter numbers!");
                }
            }


            // Implement user input
            if (first == 1) {
                if (second == 3) {
                    if (table[0][0] == 79 || table[0][0] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[0][0] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[0][0] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }

                    }
                } else if (second == 2) {
                    if (table[1][0] == 79 || table[1][0] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[1][0] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[1][0] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                } else if (second == 1) {
                    if (table[2][0] == 79 || table[2][0] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[2][0] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[2][0] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                }
            }

            else if (first == 2) {
                if (second == 3) {
                    if (table[0][1] == 79 || table[0][1] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[0][1] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[0][1] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                } else if (second == 2) {
                    if (table[1][1] == 79 || table[1][1] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[1][1] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[1][1] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                } else if (second == 1) {
                    if (table[2][1] == 79 || table[2][1] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[2][1] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[2][1] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                }
            }

            else if (first == 3) {
                if (second == 3) {
                    if (table[0][2] == 79 || table[0][2] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[0][2] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[0][2] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                } else if (second == 2) {
                    if (table[1][2] == 79 || table[1][2] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[1][2] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[1][2] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                } else if (second == 1) {
                    if (table[2][2] == 79 || table[2][2] == 88) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        if (turnOfX == true) {
                            table[2][2] = x;
                            moveSuccessful = true;
                            turnOfX = false;
                        } else {
                            table[2][2] = o;
                            moveSuccessful = true;
                            turnOfX = true;
                        }
                    }
                }

            }
        }
    }
}