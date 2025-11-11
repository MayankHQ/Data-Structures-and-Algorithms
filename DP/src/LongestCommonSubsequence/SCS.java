package LongestCommonSubsequence;
// shortest common subsequence
// code is same as finding length of lcs, just in the ending "return m+n - dp[m][n]"

/* public class SCS {

    public static int scsLength(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n + m - dp[n][m];
    }

    public static void main(String[] args) {
        String s1="abac";
        String s2="cab";
        System.out.println("SCS Length: " + scsLength(s1,s2));
    }
}*/


// Now for printing lcs

public class SCS {

    public static String scs(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n+1][m+1];

        // Fill LCS DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // Now build SCS using dp table (backtrack)
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));  // take common char once
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                sb.append(s1.charAt(i-1));  // take from s1
                i--;
            } else {
                sb.append(s2.charAt(j-1));  // take from s2
                j--;
            }
        }

        // Add remaining characters
        while (i > 0) sb.append(s1.charAt(--i));
        while (j > 0) sb.append(s2.charAt(--j));

        return sb.reverse().toString(); // reverse result
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";

        System.out.println("SCS: " + scs(s1, s2));
    }
}
