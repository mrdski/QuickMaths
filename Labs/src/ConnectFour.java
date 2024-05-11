import java.util.Scanner;
public class ConnectFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What would you like the height of the board to be? ");
        int height = input.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int length = input.nextInt();
        char[][] board = new char[height][length];
        initializeBoard(board);
        printBoard(board);
        char xType = 'x';
        char oType = 'o';
        System.out.println("Player 1: " + xType);
        System.out.println("Player 2: " + oType);
        boolean isDone = false;
        while(!isDone){
            System.out.print("Player 1: Which column would you like to choose? ");  //Player 1 turn
            int colP1 = input.nextInt();
            int rowP1 = insertChip(board, colP1, xType);
            printBoard(board);
            System.out.println();
            boolean cWP1 = checkIfWinner(board, colP1, rowP1, xType);
            if(cWP1){
                System.out.print("Player 1 won the game!");
                isDone = true;
                break;
            }
            if(isFull(board)){
                System.out.println("Draw. Nobody wins.");
                isDone = true;
                break;
            }
            System.out.print("Player 2: Which column would you like to choose? ");  //Player 2 turn
            int colP2 = input.nextInt();
            int rowP2 = insertChip(board, colP2, oType);
            printBoard(board);
            System.out.println();
            boolean cWP2 = checkIfWinner(board, colP2, rowP2, oType);
            if(cWP2){
                System.out.print("Player 2 won the game!");
                isDone = true;
                break;
            }
            if(isFull(board)){
                System.out.println("Draw. Nobody wins.");
                isDone = true;
            }
        }
    }
    public static boolean isFull(char[][] array){
        boolean f = true;
        for(int i = 0; i < array.length; i++){             //made a method to see if it's a tie
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == '-')
                    f = false;
            }
        }
        return f;
    }
    public static void printBoard(char[][] array){
        for(int i = array.length-1; i >= 0; i--){       //printing the board upside down because the bottom is suppose to be row 0
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    public static void initializeBoard(char[][] array){
        for(int i = 0; i < array.length; i++){          //setting all the values on the board to -
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = '-';
            }
        }
    }
    public static int insertChip(char[][] array, int col, char chipType){
        int row = array.length-1;
        for(int i = 0; i < array.length; i++){  //loop to determine what position the chip will be at
            if(array[i][col] == '-'){
                array[i][col] = chipType;
                row = i;
                break;
            }
        }
        return row;
    }
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        boolean cIfW = false;
        int cCount = 0;
        for(int i = 0; i < array.length; i++) {     //loop for 4 up/down
            if (array[i][col] == chipType)
                cCount += 1;
            else
                cCount = 0;
            if (cCount == 4)
                cIfW = true;
        }
        int rCount = 0;
        for(int i = 0; i < array[col].length; i++){     //loop for 4 across
            if(array[row][i] == chipType)
                rCount += 1;
            else
                rCount = 0;
            if(rCount == 4)
                cIfW = true;
        }
        return cIfW;
    }
}
