package LongestCommonSubsequence;
import java.util.*;


public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(m, n, word1, word2, dp);
    }
    public static int helper(int i, int j, String a, String b, int[][] dp){
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i-1) == b.charAt(j-1)){
            return helper(i-1, j-1, a, b, dp);
        }
        int insert = helper(i, j-1, a,b, dp);
        int delete = helper(i-1, j, a, b, dp);
        int replace = helper(i-1, j-1, a,b, dp);
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    public static void main(String[] args) {
        String a = "horse";
        String b = "ros";
        System.out.println(minDistance(a, b));
    }
}

//class Solution {
//    public int minDistance(String word1, String word2) {
//        int m = word1.length(), n = word2.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; i++) dp[i][0] = i;
//        for (int j = 0; j <= n; j++) dp[0][j] = j;
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    int insert = dp[i][j - 1];
//                    int delete = dp[i - 1][j];
//                    int replace = dp[i - 1][j - 1];
//                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
//                }
//            }
//        }
//        return dp[m][n];
//    }


//class Solution {
//    public int minDistance(String word1, String word2) {
//        int m = word1.length(), n = word2.length();
//        int[] prev = new int[n + 1];
//        for (int j = 0; j <= n; j++) prev[j] = j;
//
//        for (int i = 1; i <= m; i++) {
//            int[] curr = new int[n + 1];
//            curr[0] = i;
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    curr[j] = prev[j - 1];
//                } else {
//                    int insert = curr[j - 1];
//                    int delete = prev[j];
//                    int replace = prev[j - 1];
//                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
//                }
//            }
//            prev = curr;
//        }
//        return prev[n];
//    }
//}