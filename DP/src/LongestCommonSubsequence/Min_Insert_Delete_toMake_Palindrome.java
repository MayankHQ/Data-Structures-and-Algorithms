package LongestCommonSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Min_Insert_Delete_toMake_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String rev = new StringBuilder(a).reverse().toString();
        int[][] dp = new int[a.length() + 1][rev.length() + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(a.length() - lcs(a, rev, a.length(), rev.length(), dp));
    }
    public static int lcs(String a, String rev, int m, int n, int[][] dp){
        if(m == 0 || n == 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(a.charAt(m-1) == rev.charAt(n-1)){
            return dp[m][n] = 1 + lcs(a, rev, m-1, n-1, dp);
        }
        else{
            return dp[m][n] = Math.max(lcs(a, rev, m-1, n, dp), lcs(a, rev, m, n-1, dp));
        }
    }
}
