"""
Approach

Pick No Pick
"""

"""
Recursion
"""

class Solution {

    static int coin(int[] coins, int i, int amount){
        if(amount==0) return 0;
        if(i==0){
            if(amount%coins[i]==0) return amount/coins[i];
            return 10001;
        }

        int nopick = coin(coins, i-1, amount);
        int pick = 10001;
        if(amount>=coins[i]){
            pick = 1 + coin(coins, i, amount-coins[i]);
        }

        return Math.min(pick,nopick);
    }

    public int coinChange(int[] coins, int amount) {
        int c = coin(coins, coins.length-1, amount);
        if(c<10001) return c;
        return -1;
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int coin(int[] coins, int i, int amount, int[][] dp){
        if(amount==0) return 0;
        if(i==0){
            if(amount%coins[i]==0) return amount/coins[i];
            return 10001;
        }

        if(dp[i][amount]!=0) return dp[i][amount];

        int nopick = coin(coins, i-1, amount, dp);
        int pick = 10001;
        if(amount>=coins[i]){
            pick = 1 + coin(coins, i, amount-coins[i], dp);
        }

        return dp[i][amount] = Math.min(pick,nopick);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        int c = coin(coins, coins.length-1, amount, dp);
        if(c<10001) return c;
        return -1;
    }
}
  
"""
Tabulation
"""

class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : 10001;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int nopick = dp[i-1][j];
                int pick = 10001;
                if (j >= coins[i]) {
                    pick = 1 + dp[i][j-coins[i]];
                }

                dp[i][j] = Math.min(pick, nopick);
            }
        }
        int c = dp[n-1][amount];
        if (c < 10001)
            return c;
        return -1;
    }
}

"""
Space Optimisation
"""

class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = i % coins[0] == 0 ? i / coins[0] : 10001;
        }
        for (int i = 1; i < n; i++) {
            int[] temp = new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                int nopick = dp[j];
                int pick = 10001;
                if (j >= coins[i]) {
                    pick = 1 + temp[j-coins[i]];
                }

                temp[j] = Math.min(pick, nopick);
            }
            dp = temp;
        }
        int c = dp[amount];
        if (c < 10001)
            return c;
        return -1;
    }
}
