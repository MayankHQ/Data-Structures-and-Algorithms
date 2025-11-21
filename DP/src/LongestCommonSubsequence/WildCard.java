package LongestCommonSubsequence;
import java.util.*;

public class WildCard {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(n, m, p, s, dp) == 1 ? true: false;
    }
    public static int helper(int i, int j, String a, String b, int[][] dp){

        if(i == 0 && j == 0) return 1;
        if(i == 0 && j > 0) return 0;
        if(j == 0 && i > 0){
            for(int k = 1; k <= i; k++){
                if(a.charAt(k) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i-1) == b.charAt(j-1) || a.charAt(i-1) == '?'){
            return dp[i][j] = helper(i-1, j-1, a, b, dp);
        }
        if(a.charAt(i-1) == '*'){
            //skip the * and continue with rest of string a or consider * and compare it with string b
            return dp[i][j] = ((helper(i-1, j, a, b, dp) == 1) || (helper(i, j-1, a, b, dp) == 1)) ? 1 : 0;
        }
        return dp[i][j] = 0;
    }

    public static void main(String[] args) {
        String s = "abdefcd";
        String p = "ab*cd";
        System.out.println(isMatch(s, p));
    }
}

/*
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n +1];

        dp[0][0] = true;
        for(int i = 1; i<=m; i++){
            dp[i][0] = false;
        }

        for(int j = 1; j <= n; j++){
            boolean flag = true;
            for(int k = 1; k <= j; k++){
                if(p.charAt(k-1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for(int i = 1; i <=m; i++){
            for(int j = 1; j <= n; j++){
                if((s.charAt(i-1) == p.charAt(j-1)) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    //skip the * and continue with rest of string a or consider * and compare it with string b
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}


class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] prev = new boolean[n +1];

        prev[0] = true;
        // for(int i = 1; i<=m; i++){
        //     dp[i][0] = false;
        // }

        for(int j = 1; j <= n; j++){
            boolean flag = true;
            for(int k = 1; k <= j; k++){
                if(p.charAt(k-1) != '*'){
                    flag = false;
                    break;
                }
            }
            prev[j] = flag;
        }

        for(int i = 1; i <=m; i++){
            boolean[] curr = new boolean[n+1];
            curr[0] = false;
            for(int j = 1; j <= n; j++){
                if((s.charAt(i-1) == p.charAt(j-1)) || p.charAt(j-1) == '?'){
                    curr[j] = prev[j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    //skip the * and continue with rest of string a or consider * and compare it with string b
                    curr[j] = curr[j-1] || prev[j];
                }
                else{
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}
*/
