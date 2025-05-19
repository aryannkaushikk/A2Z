"""
Approach 1

Same as before, buy-no buy and sell-no sell, but you also add another arguement transactions which cant be >=2 else return
Transactions increase everytime you sell
"""

"""
Recursion
"""

class Solution {

    static int stock(int[] prices, int i, int b, int t){
        if(t==2) return 0;
        if(i==prices.length) return 0;

        int profit = 0;

        if(b==1){
            int buy = -prices[i] + stock(prices, i+1, 0, t);
            int nobuy = stock(prices, i+1, 1, t);
            profit = Math.max(buy, nobuy);
        }else{
            int sell = prices[i] + stock(prices, i+1, 1, t+1);
            int nosell = stock(prices, i+1, 0, t);
            profit = Math.max(sell, nosell);
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        return stock(prices, 0, 1, 0);
    }
}
  
"""
Recursion + Memoization
"""

class Solution {

    static int stock(int[] prices, int i, int b, int t, int[][][] dp){
        if(t==2) return 0;
        if(i==prices.length) return 0;

        if(dp[i][b][t]!=-1) return dp[i][b][t];

        int profit = 0;

        if(b==1){
            int buy = -prices[i] + stock(prices, i+1, 0, t, dp);
            int nobuy = stock(prices, i+1, 1, t, dp);
            profit = Math.max(buy, nobuy);
        }else{
            int sell = prices[i] + stock(prices, i+1, 1, t+1, dp);
            int nosell = stock(prices, i+1, 0, t, dp);
            profit = Math.max(sell, nosell);
        }
        return dp[i][b][t] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        for(int i = 0; i<n; i++){
            for(int b = 0; b<=1; b++){
                Arrays.fill(dp[i][b], -1);
            }
        }
        return stock(prices, 0, 1, 0, dp);
    }
}
  
"""
Tabulation
"""

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i = n-1; i>=0; i--){
            for(int b = 0; b<=1; b++){
                for(int t = 0; t<=1; t++){
                    int profit = 0;

                    if(b==1){
                        int buy = -prices[i] + dp[i+1][0][t];
                        int nobuy = dp[i+1][1][t];
                        profit = Math.max(buy, nobuy);
                    }else{
                        int sell = prices[i] + dp[i+1][1][t+1];
                        int nosell = dp[i+1][0][t];
                        profit = Math.max(sell, nosell);
                    }
                    dp[i][b][t] = profit;
                }
            }
        }
        return dp[0][1][0];
    }
}
  
"""
Space Optimisation
"""

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][3];
        for(int i = n-1; i>=0; i--){
            int[][] temp = new int[2][3];
            for(int b = 0; b<=1; b++){
                for(int t = 0; t<=1; t++){
                    int profit = 0;

                    if(b==1){
                        int buy = -prices[i] + dp[0][t];
                        int nobuy = dp[1][t];
                        profit = Math.max(buy, nobuy);
                    }else{
                        int sell = prices[i] + dp[1][t+1];
                        int nosell = dp[0][t];
                        profit = Math.max(sell, nosell);
                    }
                    temp[b][t] = profit;
                }
            }
            dp = temp;
        }
        return dp[1][0];
    }
}

"""
Approach 2

Here except for index the other arguement is transaction only which can have values 0-3
Every even value means buying and odd means selling and 4 means 2 transactions done so return
"""

"""
Recursion
"""
 
class Solution {

    static int stock(int[] prices, int i, int tr){
        if(i==prices.length || tr==4) return 0;

        int profit = 0;
        
        if(tr%2==0){
            int buy = -prices[i] + stock(prices, i+1, tr+1);
            int nobuy = stock(prices, i+1, tr);
            profit = Math.max(buy, nobuy);
        }else{
            int sell = prices[i] + stock(prices, i+1, tr+1);
            int nosell = stock(prices, i+1, tr);
            profit = Math.max(sell, nosell);
        }

        return profit;
    }

    public int maxProfit(int[] prices) {
        return stock(prices, 0, 0);
    }
}
 
"""
Recursion + Memoization
"""

class Solution {

    static int stock(int[] prices, int i, int tr, int[][] dp){
        if(i==prices.length || tr==4) return 0;

        if(dp[i][tr]!=-1) return dp[i][tr];

        int profit = 0;
        
        if(tr%2==0){
            int buy = -prices[i] + stock(prices, i+1, tr+1, dp);
            int nobuy = stock(prices, i+1, tr, dp);
            profit = Math.max(buy, nobuy);
        }else{
            int sell = prices[i] + stock(prices, i+1, tr+1, dp);
            int nosell = stock(prices, i+1, tr, dp);
            profit = Math.max(sell, nosell);
        }

        return dp[i][tr] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return stock(prices, 0, 0, dp);
    }
}

"""
Tabulation
"""

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];
        for(int i = n-1; i>=0; i--){
            for(int tr = 0; tr<4; tr++){
                int profit = 0;
        
                if(tr%2==0){
                    int buy = -prices[i] + dp[i+1][tr+1];
                    int nobuy = dp[i+1][tr];
                    profit = Math.max(buy, nobuy);
                }else{
                    int sell = prices[i] + dp[i+1][tr+1];
                    int nosell = dp[i+1][tr];
                    profit = Math.max(sell, nosell);
                }

                dp[i][tr] = profit;
            }
        }
        return dp[0][0];
    }
}

"""
Space Optimisation
"""

class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[5];
        for(int i = n-1; i>=0; i--){
            int[] temp = new int[5];
            for(int tr = 0; tr<4; tr++){
                int profit = 0;
        
                if(tr%2==0){
                    int buy = -prices[i] + dp[tr+1];
                    int nobuy = dp[tr];
                    profit = Math.max(buy, nobuy);
                }else{
                    int sell = prices[i] + dp[tr+1];
                    int nosell = dp[tr];
                    profit = Math.max(sell, nosell);
                }

                temp[tr] = profit;
            }
            dp = temp;
        }
        return dp[0];
    }
}
