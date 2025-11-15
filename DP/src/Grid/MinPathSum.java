package Grid;
import java.util.Arrays;

//MEMOIZED

public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1, grid, dp);
    }
    public static int helper(int i, int j, int[][] arr, int[][] dp){
        if(i == 0 && j == 0) return arr[0][0];
        if(i < 0 || j < 0) return (int) 1e9;
        if(dp[i][j] != -1) return dp[i][j];

        int up =  helper(i-1, j, arr, dp);
        int left = helper(i, j-1, arr, dp);

        return dp[i][j] = arr[i][j] + Math.min(up,left);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}

//TABULATED

//class Solution {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[][] dp = new int[m][n];
//
//        dp[0][0] = grid[0][0];
//
//        for(int i = 1; i < m; i++){
//            dp[i][0] = grid[i][0] + dp[i-1][0];
//        }
//        for(int j = 1; j < n; j++){
//            dp[0][j] = grid[0][j] + dp[0][j-1];
//        }
//
//        for(int i = 1; i < m; i++){
//            for (int j = 1; j < n; j++){
//                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
//            }
//        }
//        return dp[m-1][n-1];
//    }
//}


//SPACE OPTIMIZED

// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[] prev = new int[n];
//         prev[0] = grid[0][0];
//         for(int i = 1; i < n; i++){
//             prev[i] = grid[0][i] + prev[i-1];
//         }
//         for(int i = 1; i < m; i++){
//             int[] curr = new int[n];
//             curr[0] = grid[i][0] + prev[0];
//             for(int j = 1; j < n; j++){
//                 curr[j] = grid[i][j] + Math.min(curr[j-1], prev[j]);
//             }
//             prev = curr;
//         }
//         return prev[n-1];
//     }
// }

