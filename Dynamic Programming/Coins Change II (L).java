"""
Approach

Same as Coins Change just need to count number of possible combinations
"""

"""
Recursion
"""

class Solution {

    static int coin(int[] coins, int i, int amount){
        if(amount==0) return 1;
        if(i==0){
            if(amount%coins[i]==0) return 1;
            return 0;
        }

        int nopick = coin(coins, i-1, amount);
        int pick = 0;
        if(coins[i]<=amount){
            pick = coin(coins, i, amount-coins[i]);
        }

        return nopick + pick;
    }

    public int change(int amount, int[] coins) {
        int c = coin(coins, coins.length-1, amount);
        return c;
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int coin(int[] coins, int i, int amount, int[][] dp){
        if(amount==0) return 1;
        if(i==0){
            if(amount%coins[i]==0) return 1;
            return 0;
        }

        if(dp[i][amount]!=0) return dp[i][amount];

        int nopick = coin(coins, i-1, amount, dp);
        int pick = 0;
        if(coins[i]<=amount){
            pick = coin(coins, i, amount-coins[i], dp);
        }

        return dp[i][amount] = nopick + pick;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        int c = coin(coins, n-1, amount, dp);
        return c;
    }
}
  
"""
Tabulation
"""

class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {

                int nopick = dp[i-1][j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = dp[i][j-coins[i]];
                }

                dp[i][j] = nopick + pick;
            }
        }
        int c = dp[n-1][amount];
        return c;
    }
}
  
"""
Space Optimisation
"""

class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i <= amount; i++) {
            dp[i] = i % coins[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            int[] temp = new int[amount+1];
            for (int j = 0; j <= amount; j++) {

                int nopick = dp[j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = temp[j-coins[i]];
                }

                temp[j] = nopick + pick;
            }
            dp = temp;
        }
        int c = dp[amount];
        return c;
    }
}
