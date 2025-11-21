package Stocks.Stocks3;
import java.util.*;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the
stock before you buy again).
 */
public class secondMethod {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int[][] row : dp){
            for(int[] col : row){
                Arrays.fill(col, -1);
            }
        }
        return helper(0,1,2,prices,dp);
    }
    public static int helper(int index, int buy, int cap, int[] prices, int[][][] dp){
        if(index == prices.length) return 0;
        if(cap == 0) return 0;
        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[index] + helper(index + 1, 0, cap, prices, dp)), 0 + helper(index + 1, 1,cap, prices, dp));
        }
        else{
            profit = Math.max((prices[index] + helper(index + 1, 1,cap-1, prices, dp)), 0 + helper(index + 1, 0,cap,prices, dp));
        }
        return dp[index][buy][cap] = profit;
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
        int[][][] dp = new int[n+1][2][3];

        // u can skip this part its just for clarification

        for(int idx = 0; idx < n; idx++){
            for(int buy = 0; buy < 2; buy++){
                dp[idx][buy][0] = 0;
            }
        }
        for(int buy = 0; buy <= 1; buy++){
            for(int cap = 0; cap <= 2; cap++){
                dp[n][buy][cap] = 0;
            }
        }

        for(int idx = n-1; idx >= 0; idx--){
        for(int buy = 0; buy <= 1; buy++){
        for(int cap = 1; cap <= 2; cap++){
        if(buy == 1){
        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][0][cap], 0 + dp[idx + 1][1][cap]);
                    }
                            else{
        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][1][cap-1], 0 + dp[idx + 1][0][cap]);
                    }
                            }
                            }
                            }
                            return dp[0][1][2];
        }
        }
 */

/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];

        for(int idx = n-1; idx >= 0; idx--){
            int[][] curr = new int[2][3];
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1){
                        curr[buy][cap] = Math.max(-prices[idx] + after[0][cap], 0 + after[1][cap]);
                    }
                    else{
                        curr[buy][cap] = Math.max(prices[idx] + after[1][cap-1], 0 + after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        return after[1][2];
    }
}
 */