package Grid;

import java.util.*;

public class UniquePath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = 3;
        int n = 6;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        // System.out.println(uniquePaths(m,n,dp)); for recursive one
        System.out.println(uniquePaths(m,n));
    }
    /*
    Recursive and memoized solution (Top- down)

    public static int uniquePaths(int i, int j, int[][] dp){
        if (i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = uniquePath(i-1, j, dp) + uniquePath(i, j-1, dp);
    }*/

//    public static int uniquePaths(int m, int n, int[][] dp) {
////        int[][] dp = new int[m][n];
//
//        for(int i = 0; i < m; i++){
//            dp[i][0] = 1;
//        }
//        for(int j = 1; j < n; j++){
//            dp[0][j] = 1;
//        }
//
//        for(int i = 1; i < m; i++){
//            for(int j = 1; j < n; j++){
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
//    }
    public static int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        // first row = all 1s
        Arrays.fill(prev, 1);

        for (int i = 1; i < m; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {

                // first column is always 1
                if (j == 0) {
                    curr[j] = 1;
                } else {
                    // dp[i][j] = dp[i][j-1] + dp[i-1][j]
                    curr[j] = curr[j - 1] + prev[j];
                }
            }

            prev = curr;
        }

        return prev[n - 1];
    }
//    public static int uniquePaths(int m, int n) {
//         int[] prev = new int[n];
//
//         for(int i = 0; i < m; i++){
//             int[] curr = new int[n];
//             for(int j = 0; j < n; j++){
//                 if(i == 0 && j == 0) {
//                     curr[j] = 1;
//                     continue;
//                 }
//
//                 int up = 0, left = 0;
//                 if(i > 0) up = prev[j];
//                 if(j > 0) left = curr[j-1];
//
//                 curr[j] = up + left;
//             }
//             prev = curr;
//         }
//         return prev[n-1];
    // }
}
