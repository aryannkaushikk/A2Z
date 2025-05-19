"""
Approach

If buy = 1, you can:
  1. Buy
  2. Not Buy

If buy = 0, you can:
  1. Sell
  2. Not Sell
"""

"""
Recursion
"""

class Solution {

    static int stock(int[] prices, int i, int b){
        if(i==prices.length) return 0;

        int profit = 0;

        if(b==1){
            int buy = -prices[i] + stock(prices, i+1, 0);
            int nobuy = stock(prices, i+1, 1);
            profit = Math.max(buy, nobuy);
        }else{
            int sell = prices[i] + stock(prices, i+1, 1);
            int nosell = stock(prices, i+1, 0);
            profit = Math.max(sell, nosell);
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        return stock(prices, 0, 1);
    }
}
  
"""
Recursion + Memoization
"""

class Solution {

    static int stock(int[] prices, int i, int b, int[][] dp){
        if(i==prices.length) return 0;

        if(dp[i][b]!=-1) return dp[i][b];

        int profit = 0;

        if(b==1){
            int buy = -prices[i] + stock(prices, i+1, 0, dp);
            int nobuy = stock(prices, i+1, 1, dp);
            profit = Math.max(buy, nobuy);
        }else{
            int sell = prices[i] + stock(prices, i+1, 1, dp);
            int nosell = stock(prices, i+1, 0, dp);
            profit = Math.max(sell, nosell);
        }
        return dp[i][b] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return stock(prices, 0, 1, dp);
    }
}
  
"""
Tabulation
"""

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = n-1; i>=0; i--){
            for(int b = 0; b<=1; b++){
                int profit = 0;

                if(b==1){
                    int buy = -prices[i] + dp[i+1][0];
                    int nobuy = dp[i+1][1];
                    profit = Math.max(buy, nobuy);
                }else{
                    int sell = prices[i] + dp[i+1][1];
                    int nosell = dp[i+1][0];
                    profit = Math.max(sell, nosell);
                }
                dp[i][b] = profit;
            }
        }
        return dp[0][1];
    }
}
  
"""
Space Optimisation
"""

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        for(int i = n-1; i>=0; i--){
            int[] temp = new int[2];
            for(int b = 0; b<=1; b++){
                int profit = 0;

                if(b==1){
                    int buy = -prices[i] + dp[0];
                    int nobuy = dp[1];
                    profit = Math.max(buy, nobuy);
                }else{
                    int sell = prices[i] + dp[1];
                    int nosell = dp[0];
                    profit = Math.max(sell, nosell);
                }
                temp[b] = profit;
            }
            dp = temp;
        }
        return dp[1];
    }
}
