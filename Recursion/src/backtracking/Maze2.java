package backtracking;

import java.util.Arrays;

public class Maze2 {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[board.length][board[0].length];
        AllPathsPrint("", board, 0, 0, path, 1);
//        AllPaths("", board,0,0);
    }
    static void AllPaths(String p,boolean[][] maze, int row, int col){

        if(row == maze.length - 1 && col == maze[0].length - 1){

            System.out.println(p);
            return;
        }

        if(!maze[row][col]){
            return;
        }
        maze[row][col] = false;
        if(row < maze.length-1){
            AllPaths(p + "D", maze,row + 1, col);
        }
        if(col < maze[0].length-1){
            AllPaths(p + "R", maze, row , col+1);
        }
        if(row > 0){
            AllPaths(p + "U", maze, row - 1, col);
        }
        if(col > 0){
            AllPaths(p + "L", maze, row, col-1);
        }

        //this line is where function gets over
        //before the function gets removed, undo the modifications that were made like changing every cell to false
        // this is backtracking

        maze[row][col] = true;
    }

    //printing all path

    static void AllPathsPrint(String p,boolean[][] maze, int row, int col, int[][] path, int step){

        if(row == maze.length - 1 && col == maze[0].length - 1){
            path[row][col] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            return;
        }

        if(!maze[row][col]){
            return;
        }
        maze[row][col] = false;
        path[row][col] = step;

        if(row < maze.length-1){
            AllPathsPrint(p + "D", maze,row + 1, col, path, step +1);
        }
        if(col < maze[0].length-1){
            AllPathsPrint(p + "R", maze, row , col+1, path, step +1);
        }
        if(row > 0){
            AllPathsPrint(p + "U", maze, row - 1, col, path, step +1);
        }
        if(col > 0){
            AllPathsPrint(p + "L", maze, row, col-1, path, step +1);
        }

        //this line is where function gets over
        //before the function gets removed, undo the modifications that were made like changing every cell to false
        // this is backtracking

        maze[row][col] = true;
        path[row][col] = 0;
    }

}
