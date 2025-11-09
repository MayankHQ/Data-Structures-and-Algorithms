package backtracking;
import java.util.*;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(countPath(3,3));
//        drawMaze("",3,3);
        boolean[][] board = {
                {true, true, true},
                {true,false,true},
                {true,true,true}
        };

        pathRestrict("", board, 0, 0);
    }
    static int countPath(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int left = countPath(row - 1, col);
        int right = countPath(row, col-1);
        return left + right;
    }
    static void drawMaze(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }
        if(row > 1 && col > 1){
            drawMaze(p + "D", row - 1, col - 1);
        }
        if(row > 1){
            drawMaze(p + "V", row - 1, col);
        }
        if(col > 1){
            drawMaze(p + "H", row , col-1);
        }
    }

    static void pathRestrict(String p, boolean[][] maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[row][col]){
            return;
        }

        if(row < maze.length-1){
            pathRestrict(p + "V", maze,row + 1, col);
        }
        if(col < maze[0].length-1){
            pathRestrict(p + "H", maze, row , col+1);
        }
    }
}
