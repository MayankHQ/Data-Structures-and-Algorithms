package Grid;
import java.util.*;


public class MinFallPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = (int)1e9;
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, (int)-1e9);
        }

        for(int i = 0; i < n; i++){
            ans = Math.min(ans, helper(n-1, i, n, matrix, dp));
        }
        return ans;
    }
    public static int helper(int i, int j, int m, int[][] arr, int[][] dp){
        if(j < 0 || j >= m) return (int)1e9;
        if(i == 0) return arr[0][j];

        if(dp[i][j] != (int)-1e9) return dp[i][j];

        int s =  helper(i-1, j, m,arr, dp);
        int ld =  helper(i-1,j-1,m,arr, dp);
        int rd = helper(i-1, j+1,m, arr, dp);

        return dp[i][j] = arr[i][j] + Math.min(s, Math.min(ld,rd));
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}

// TABULATED

//class Solution {
//    public int minFallingPathSum(int[][] matrix) {
//        int n = matrix.length;
//        int[][] dp = new int[n][n];
//
//        for(int j = 0; j < n; j++){
//            dp[0][j] = matrix[0][j];
//        }
//
//        for(int i = 1; i < n; i++){
//            for(int j = 0; j < n; j++){
//                int ld = (int)1e9, rd = (int)1e9;
//                int s = dp[i-1][j];
//                if(j-1 >= 0) ld = dp[i-1][j-1];
//                if(j+1 < n) rd = dp[i-1][j+1];
//
//                dp[i][j] = matrix[i][j] + Math.min(s, Math.min(ld, rd));
//            }
//        }
//
//        int mini = dp[n-1][0];
//
//        for(int j = 1; j < n; j++){
//            mini = Math.min(mini, dp[n-1][j]);
//        }
//        return mini;
//    }
//}

//SPACE OPTIMIZED

//class Solution {
//    public int minFallingPathSum(int[][] matrix) {
//        int n = matrix.length;
//        int[] prev = new int[n];
//        for(int j = 0; j < n; j++){
//            prev[j] = matrix[0][j];
//        }
//
//        for(int i = 1; i < n; i++){
//            int[] curr = new int[n];
//            for(int j = 0; j < n; j++){
//                int ld = (int)1e9, rd = (int)1e9;
//                int s = prev[j];
//                if(j-1 >= 0) ld = prev[j-1];
//                if(j+1 < n) rd = prev[j+1];
//
//                curr[j] = matrix[i][j] + Math.min(s, Math.min(ld, rd));
//            }
//            prev = curr;
//        }
//
//        int mini = prev[0];
//
//        for(int j = 1; j < n; j++){
//            mini = Math.min(mini, prev[j]);
//        }
//        return mini;
//    }
//}