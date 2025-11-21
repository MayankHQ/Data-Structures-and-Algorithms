package Stocks;
import java.util.*;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day
, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions
as you like, but you need to pay the transaction fee for each transaction.

Note:

-> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock
before you buy again).
-> The transaction fee is only charged once for each stock purchase and sale.
 */
public class Stocks6 {
    public static int maxProfit(int[] prices, int fee) {
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
                    profit = Math.max((prices[index] - fee + dp[index + 1][1]),0 + dp[index + 1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1]; //0 means starting from 1st day and 1 means allowed to buy
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}

/*
class Solution {
    public int maxProfit(int[] prices, int fee) {
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
                    profit = Math.max((prices[index] - fee + dp[index + 1][1]),0 + dp[index + 1][0]);
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
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] after = new int[2];

        for(int index = n-1; index >= 0; index--){

            int[] curr = new int[2];

            curr[1] = Math.max((-prices[index] + after[0]), 0 + after[1]);

            curr[0] = Math.max((prices[index] - fee + after[1]),0 + after[0]);

            after = curr;

        }
        return after[1]; //0 means starting from 1st day and 1 means allowed to buy
    }
}
 */