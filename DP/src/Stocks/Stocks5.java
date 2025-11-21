package Stocks;
import java.util.*;

/*
You are given an array prices where prices[i] is the price of a given
stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions
as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions
simultaneously (i.e., you must sell the stock before you buy again).
 */


public class Stocks5 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(0,1, prices, dp);
    }
    public static int helper(int index, int buy, int[] prices, int[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[index] + helper(index + 1, 0, prices, dp)), 0 + helper(index + 1, 1, prices, dp));
        }
        else{
            profit = Math.max((prices[index] + helper(index + 2, 1, prices, dp)), 0 + helper(index + 1, 0, prices, dp));
        }
        return dp[index][buy] = profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}

/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[n][0] = 0; dp[n][1] = 0;

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max((-prices[index] + dp[index + 1][0]),0 + dp[index + 1][1]);
                }
                else{
                    profit = Math.max((prices[index] + dp[index + 2][1]),0 + dp[index + 1][0]);
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
        int[] front1 = new int[2];
        int[] front2 = new int[2];

        for(int index = n-1; index >= 0; index--){

            int[] curr = new int[2];

            curr[1] = Math.max((-prices[index] + front1[0]),0 + front1[1]);

            curr[0] = Math.max((prices[index] + front2[1]),0 + front1[0]);

            front2 = front1;
            front1 = curr;

        }
        return front1[1]; //0 means starting from 1st day and 1 means allowed to buy
    }
}
 */