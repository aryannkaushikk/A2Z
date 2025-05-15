"""
Approach

Pick NoPick
"""

"""
Recursion
"""

class Solution {
    
    static int nap(int[] val, int[] wt, int W, int i){
        if(W==0) return 0;
        if(i==0){
            if(W>=wt[i]) return val[i];
            return 0;
        }
        
        int nopick = nap(val,wt,W,i-1);
        int pick = 0;
        if(wt[i]<=W){
            pick = val[i] + nap(val, wt, W-wt[i], i-1);
        }
        
        return Math.max(pick, nopick);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        return nap(val, wt, W, val.length-1);
    }
}

"""
Recursion + Memoization
"""


class Solution {
    
    static int nap(int[] val, int[] wt, int W, int i, int[][] dp){
        if(W==0) return dp[i][W] = 0;
        if(i==0){
            if(W>=wt[i]) return dp[i][W] = val[i];
            return dp[i][W] = 0;
        }
        
        if(dp[i][W]!=-1) return dp[i][W];
        
        int nopick = nap(val, wt, W, i-1, dp);
        int pick = 0;
        if(wt[i]<=W){
            pick = val[i] + nap(val, wt, W-wt[i], i-1, dp);
        }
        
        return dp[i][W] = Math.max(pick, nopick);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=W; j++){
                dp[i][j] = -1;
            }
        }
        nap(val, wt, W, n-1, dp);
        if(dp[n-1][W]==-1) return 0;
        return dp[n-1][W];
    }
}

"""
Tabulation
"""

class Solution {
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i = wt[0]; i<=W; i++){
            dp[0][i] = val[0];
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=W; j++){
                int nopick = dp[i-1][j];
                int pick = 0;
                if(wt[i]<=j){
                    pick = val[i] + dp[i-1][j-wt[i]];
                }
                dp[i][j] = Math.max(pick, nopick);
            }
        }
        return dp[n-1][W];
    }
}

"""
Space Optimisation
"""

class Solution {
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] dp = new int[W+1];
        for(int i = wt[0]; i<=W; i++){
            dp[i] = val[0];
        }
        for(int i = 1; i<n; i++){
            int[] temp = new int[W+1];
            for(int j = 0; j<=W; j++){
                int nopick = dp[j];
                int pick = 0;
                if(wt[i]<=j){
                    pick = val[i] + dp[j-wt[i]];
                }
                temp[j] = Math.max(pick, nopick);
            }
            dp = temp;
        }
        return dp[W];
    }
}

"""
Space Optimisation to 1D
"""

class Solution {
    
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] dp = new int[W+1];
        for(int i = wt[0]; i<=W; i++){
            dp[i] = val[0];
        }
        for(int i = 1; i<n; i++){
            for(int j = W; j>=0; j--){
                int nopick = dp[j];
                int pick = 0;
                if(wt[i]<=j){
                    pick = val[i] + dp[j-wt[i]];
                }
                dp[j] = Math.max(pick, nopick);
            }
        }
        return dp[W];
    }
}
