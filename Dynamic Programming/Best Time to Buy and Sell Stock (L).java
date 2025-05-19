"""
Approach

Minimum value that the stock can be bought for is assumed as arr[0]
Profit is 0
From 1 to n-1
  Calculate cost i.e. arr[0] - min
  Check for maxProfit
  Update min if arr[i] < min
"""

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
