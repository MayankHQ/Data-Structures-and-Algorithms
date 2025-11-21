package Stocks.Stocks3;
import java.util.*;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously
 (i.e., you must sell the stock before you buy again).
 */
public class thirdMethod {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(0,0,prices,dp);
    }
    public static int helper(int index, int tran, int[] prices, int[][] dp){
        if((index == prices.length) || (tran == 4)) return 0;
        if(dp[index][tran] != -1) return dp[index][tran];
        int profit = 0;
        if(tran % 2 == 0){
            profit = Math.max((-prices[index] + helper(index + 1, tran + 1, prices, dp)), 0 + helper(index + 1, tran, prices, dp));
        }
        else{
            profit = Math.max((prices[index] + helper(index + 1, tran + 1, prices, dp)), 0 + helper(index + 1, tran, prices, dp));
        }
        return dp[index][tran] = profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}

/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];

        for(int i = 0; i < 5; i++){
            dp[0][i] = 0;
        }
        for(int index = n-1; index >= 0; index--){
            for(int t = 0; t < 4; t++){
                if(t % 2 == 0){
                    dp[index][t] = Math.max(-prices[index] + dp[index+1][t+1], dp[index+1][t]);
                }
                else{
                    dp[index][t] = Math.max(prices[index] + dp[index+1][t+1], dp[index+1][t]);
                }
            }
        }
        return dp[0][0];
    }
    //     }
    //     else{
    //         profit = Math.max((prices[index] + helper(index + 1, tran + 1, prices, dp)), 0 + helper(index + 1, tran, prices, dp));
    //     }
    //     return dp[index][tran] = profit;
    // }
}
 */

/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] after = new int[5];

        for(int index = n-1; index >= 0; index--){
            int[] curr = new int[5];
            for(int t = 0; t < 4; t++){
                if(t % 2 == 0){
                    curr[t] = Math.max(-prices[index] + after[t+1], after[t]);
                }
                else{
                    curr[t] = Math.max(prices[index] + after[t+1], after[t]);
                }
            }
            after = curr;
        }
        return after[0];
    }
    //     }
    //     else{
    //         profit = Math.max((prices[index] + helper(index + 1, tran + 1, prices, dp)), 0 + helper(index + 1, tran, prices, dp));
    //     }
    //     return dp[index][tran] = profit;
    // }
}
 */