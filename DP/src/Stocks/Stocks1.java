package Stocks;


// You are given an integer array prices where prices[i]
// is the price of NeetCoin on the ith day.
//
//You may choose a single day to buy one NeetCoin and choose a
//different day in the future to sell it.
//
//Return the maximum profit you can achieve. You may choose to not make
//any transactions, in which case the profit would be 0.

public class Stocks1 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int mini = prices[0];

        for(int i = 1; i < n; i++){

            profit = Math.max(profit, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{10,1,5,6,7,1}));
    }
}
