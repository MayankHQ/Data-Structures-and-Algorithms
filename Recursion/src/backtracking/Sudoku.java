package backtracking;

public class Sudoku {
    public static void main(String[] args) {
        //initialize 9x9 sudoku with 0 as empty cell
        int[][] sudoku = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        //if the board is solvable, print the final result
        if (solve(sudoku)) {
            display(sudoku);
        }
    }

    //recursive function to solve sudoku
    private static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {             //looping every cell
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {              //if cell is empty we will fill it with 1-9 numbers
                    for (int k = 1; k <= 9; k++) {
                        if(isSafe(board, row, col, k)){   //checking if writeful k is placed in board
                            board[row][col] = k;          //placed k temporarily
                            if(solve(board)){
                                return true;
                            }else{
                                board[row][col] = 0;        //backtracks
                            }
                        }
                    }
                    return false;           //no numbers are returned
                }
            }
        }
        return true;        //if all cells ae filled
    }

    //checking if k at (row,col) valid according to sudoku
    private static boolean isSafe(int[][] board, int row, int col, int k) {
        for(int i = 0; i < 9; i++){             //checking if k is already present in current row
            if(board[row][i] == k){return false;}
        }
        for(int i = 0; i < 9; i++){              //checking if k is already present in current col
            if(board[i][col] == k){return false;}
        }

        //top left corner of the grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        //checking if k already present in 3x3 box
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == k){return false;}
            }
        }
        return true;
    }
    static void display(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
