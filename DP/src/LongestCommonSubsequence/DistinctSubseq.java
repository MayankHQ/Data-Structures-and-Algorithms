package LongestCommonSubsequence;
import java.util.*;

public class DistinctSubseq {
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(m, n, s, t, dp);
    }
    public static int helper(int i, int j, String a, String b, int[][] dp){
        if(j == 0) return 1;
        if(i == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i-1) == b.charAt(j-1)){
            return dp[i][j] = helper(i-1, j-1, a, b, dp) + helper(i-1, j, a, b, dp);
        }
        return dp[i][j] = helper(i-1, j, a, b, dp);
    }

    public static void main(String[] args) {
        String a = "babgbag";
        String b = "bag";
        System.out.println(numDistinct(a, b));
    }
}


// public int numDistinct(String s, String t){
//     int m = s.length();
//     int n = t.length();

//     int[][] dp = new int[m+1][n+1];

//     for(int i = 0; i <= m; i++) dp[i][0] = 1;
//     for(int j = 1; j <=n; j++) dp[0][j] = 0;

//     for(int i = 1; i <= m; i++){
//         for(int j = 1; j <= n; j++){
//             if(s.charAt(i-1) == t.charAt(j-1)){
//                 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//             }
//             else{
//                 dp[i][j] = dp[i-1][j];
//             }
//         }
//     }
//     return dp[m][n];
// }


//public int numDistinct(String s, String t){
//    int m = s.length();
//    int n = t.length();
//
//    int[] prev = new int[n+1];
//    prev[0] = 1;
//
//    for(int i = 1; i <= m; i++){
//        int[] curr = new int[n+1];
//        curr[0] = 1;
//        for(int j = 1; j <= n; j++){
//            if(s.charAt(i-1) == t.charAt(j-1)){
//                curr[j] = prev[j-1] + prev[j];
//            }
//            else{
//                curr[j] = prev[j];
//            }
//        }
//        prev = curr;
//    }
//    return prev[n];
//}
