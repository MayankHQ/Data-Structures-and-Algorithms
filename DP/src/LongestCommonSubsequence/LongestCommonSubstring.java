package LongestCommonSubsequence;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abcfd";
        System.out.println(lcs(s1, s2));
    }
    public static int lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        int maxLen = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
}


