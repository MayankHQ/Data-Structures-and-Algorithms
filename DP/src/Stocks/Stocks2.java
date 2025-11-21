package Stocks;
import java.util.*;


/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share
 of the stock at any time. However, you can sell and buy the stock multiple times on the
 same day, ensuring you never hold more than one share of the stock.

Find and return the maximum profit you can achieve.
 */
public class Stocks2 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(0,1, prices, dp);
    }
    public static int helper(int index, int buy, int[] prices, int[][] dp){
        if(index == prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[index] + helper(index + 1, 0, prices, dp)), 0 + helper(index + 1, 1, prices, dp));
        }
        else{
            profit = Math.max((prices[index] + helper(index + 1, 1, prices, dp)), 0 + helper(index + 1, 0, prices, dp));
        }
        return dp[index][buy] = profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}


/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = 0; dp[n][1] = 0;

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max((-prices[index] + dp[index + 1][0]),0 + dp[index + 1][1]);
                }
                else{
                    profit = Math.max((prices[index] + dp[index + 1][1]),0 + dp[index + 1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1]; //0 means starting from 1st day and 1 means allowed to buy
    }
}
 */

/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        ahead[0] = 0; ahead[1] = 0;

        for(int index = n-1; index >= 0; index--){
            int[] curr = new int[2];
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max((-prices[index] + ahead[0]),0 + ahead[1]);
                }
                else{
                    profit = Math.max((prices[index] + ahead[1]),0 + ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[1]; //0 means starting from 1st day and 1 means allowed to buy
    }
}
 */