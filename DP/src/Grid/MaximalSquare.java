package Grid;
import java.util.*;


public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSide = 0;

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i < m; i++){
            dp[i][0] = (matrix[i][0] == '1') ? 1 : 0;
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for(int j = 1; j < n; j++){
            dp[0][j] = (matrix[0][j] == '1') ? 1 : 0;
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i-1][j-1] == '0') dp[i][j] = 0;
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }

                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        // int ans = 0;
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         ans += dp[i][j];
        //     }
        // }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));
    }
}
