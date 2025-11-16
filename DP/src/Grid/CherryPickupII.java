package Grid;
import java.util.*;

public class CherryPickupII{
     public static int cherryPickup(int[][] grid) {
         int m = grid.length;
         int n = grid[0].length;
         int[][][] dp = new int[m][n][n];
         for(int[][] row : dp) {
             for (int[] col : row) {
                 Arrays.fill(col, -1);
             }
         }

         return helper(0, 0, n-1, grid, dp);
     }
     public static int helper(int i, int j1, int j2, int[][] arr, int[][][] dp){
         int m = arr.length;
         int n = arr[0].length;
         int maxi = (int)-1e8 ;
         if(j1 < 0 || j1 >= n || j2 < 0 || j2 >=n) return (int)-1e9;
         if(i == m-1){
             if(j1 == j2) return arr[i][j1];
             else{
                 return arr[i][j1] + arr[i][j2];
             }
         }
         if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

         //explore all 9 paths for robot1 and robot2

         for(int dj1 = -1; dj1 <= 1; dj1++){
             for(int dj2 = -1; dj2 <=1; dj2++){
                 if(j1 == j2){
                     maxi = Math.max(maxi, arr[i][j1] + helper(i+1, j1+dj1, j2+dj2, arr, dp));
                 }
                 else{
                     maxi = Math.max(maxi, arr[i][j1] + arr[i][j2] + helper(i+1, j1+dj1, j2+dj2, arr, dp));
                 }
             }
         }
         return dp[i][j1][j2] = maxi;
     }

    public static void main(String[] args) {
        int[][] grid = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };

        System.out.println(cherryPickup(grid));
    }
 }


// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//         int[][][] dp = new int[m][n][n];

//         for(int j1 = 0; j1 < n; j1++){
//             for(int j2 = 0; j2 < n; j2++){
//                 if(j1 == j2) dp[m-1][j1][j2] = grid[m-1][j1];
//                 else{
//                     dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
//                 }
//             }
//         }

//         for(int i = m-2; i >= 0; i--){
//             for(int j1 = 0; j1 < n; j1++){
//                 for(int j2 = 0; j2 < n; j2++){

//                     int maxi = (int)-1e8;
//                     for(int dj1 = -1; dj1 <= 1; dj1++){
//                         for(int dj2 = -1; dj2 <=1; dj2++){
//                             int value = 0;
//                             if(j1 == j2){
//                                 value = grid[i][j1];
//                             }
//                             else{
//                                 value = grid[i][j1] + grid[i][j2];
//                             }
//                             if(j1+dj1 >= 0 && j1+dj1 < n && j2+dj2 >= 0 && j2+dj2 < n){
//                                 value += dp[i+1][j1+dj1][j2+dj2];
//                             }
//                             else{
//                                 value += (int)-1e8;
//                             }
//                             maxi = Math.max(maxi, value);

//                         }
//                     }
//                     dp[i][j1][j2] = maxi;
//                 }
//             }
//         }
//         return dp[0][0][n-1];
//     }
// }




//class Solution {
//    public int cherryPickup(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[][] front = new int[n][n];
//
//
//        for(int j1 = 0; j1 < n; j1++){
//            for(int j2 = 0; j2 < n; j2++){
//                if(j1 == j2) front[j1][j2] = grid[m-1][j1];
//                else{
//                    front[j1][j2] = grid[m-1][j1] + grid[m-1][j2];
//                }
//            }
//        }
//
//        for(int i = m-2; i >= 0; i--){
//            int[][] curr = new int[n][n];
//            for(int j1 = 0; j1 < n; j1++){
//                for(int j2 = 0; j2 < n; j2++){
//
//                    int maxi = (int)-1e8;
//                    for(int dj1 = -1; dj1 <= 1; dj1++){
//                        for(int dj2 = -1; dj2 <=1; dj2++){
//                            int value = 0;
//                            if(j1 == j2){
//                                value = grid[i][j1];
//                            }
//                            else{
//                                value = grid[i][j1] + grid[i][j2];
//                            }
//                            if(j1+dj1 >= 0 && j1+dj1 < n && j2+dj2 >= 0 && j2+dj2 < n){
//                                value += front[j1+dj1][j2+dj2];
//                            }
//                            else{
//                                value += (int)-1e8;
//                            }
//                            maxi = Math.max(maxi, value);
//
//                        }
//                    }
//                    curr[j1][j2] = maxi;
//                }
//            }
//            front = curr;
//        }
//        return front[0][n-1];
//    }
//}