package Stocks;
import java.util.*;

/*
You are given an integer array prices where prices[i] is the price of a given
stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k
transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously
(i.e., you must sell the stock before you buy again).
 */
public class Stocks4  {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(k, 0,0,prices,dp);
    }
    public static int helper(int k, int index, int tran, int[] prices, int[][] dp){
        if((index == prices.length) || (tran == 2*k)) return 0;
        if(dp[index][tran] != -1) return dp[index][tran];
        int profit = 0;
        if(tran % 2 == 0){
            profit = Math.max((-prices[index] + helper(k, index + 1, tran + 1, prices, dp)), 0 + helper(k, index + 1, tran, prices, dp));
        }
        else{
            profit = Math.max((prices[index] + helper(k, index + 1, tran + 1, prices, dp)), 0 + helper(k, index + 1, tran, prices, dp));
        }
        return dp[index][tran] = profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k,prices));
    }
}

/*
public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int m = 2*k;
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= m; i++){
            dp[0][i] = 0;
        }
        for(int index = n-1; index >= 0; index--){
            for(int t = 0; t < m; t++){
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
 */