package Stocks.Stocks3;
import java.util.*;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock
before you buy again).
 */

public class firstMethod {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(0,1, prices, dp);
    }
    public static int helper(int index, int buy, int[] prices, int[][] dp){
        if(index == prices.length) return 0;
        if(buy >= 5) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1 || buy == 3){
            profit = Math.max((-prices[index] + helper(index + 1, buy + 1, prices, dp)), 0 + helper(index + 1, buy, prices, dp));
        }
        else if(buy == 2 || buy == 4){
            profit = Math.max((prices[index] + helper(index + 1, buy+1, prices, dp)), 0 + helper(index + 1, buy, prices, dp));
        }
        return dp[index][buy] = profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}