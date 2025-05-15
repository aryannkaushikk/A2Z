"""
Approach

Same Pick No Pick plus Coins Change approach if infinite inventory available
"""

"""
Recursion
"""

class Solution {
    
    static int nap(int val[], int wt[], int i, int cap){
        if(cap==0) return 0;
        if(i==0){
            if(cap>=wt[i]) return val[i] * (cap/wt[i]);
            return 0;
        }
        
        int nopick = nap(val, wt, i-1, cap);
        int pick = 0;
        if(cap>=wt[i]){
            pick = val[i] + nap(val, wt, i, cap-wt[i]);
        }
        
        return Math.max(pick, nopick);
    }
    
    static int knapSack(int val[], int wt[], int capacity) {
        return nap(val, wt, val.length-1, capacity);
    }
}
  
"""
Recursion + Memoization
"""

class Solution {
    
    static int nap(int val[], int wt[], int i, int cap, int[][] dp){
        if(cap==0) return 0;
        if(i==0){
            if(cap>=wt[i]) return val[i] * (cap/wt[i]);
            return 0;
        }
        
        if(dp[i][cap]!=0) return dp[i][cap];
        
        int nopick = nap(val, wt, i-1, cap, dp);
        int pick = 0;
        if(cap>=wt[i]){
            pick = val[i] + nap(val, wt, i, cap-wt[i], dp);
        }
        
        return dp[i][cap] = Math.max(pick, nopick);
    }
    
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        return nap(val, wt, val.length-1, capacity, dp);
    }
}

"""
Tabulation
"""

class Solution {
    
    static int knapSack(int val[], int wt[], int cap) {
        int n = val.length;
        int[][] dp = new int[n][cap+1];
        for(int i = wt[0]; i<=cap; i++){
            dp[0][i] = val[0] * (i/wt[0]);
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=cap; j++){
                int nopick = dp[i-1][j];
                int pick = 0;
                if(j>=wt[i]){
                    pick = val[i] + dp[i][j-wt[i]];
                }
        
                dp[i][j] = Math.max(pick, nopick);
            }
        }
        return dp[n-1][cap];
    }
}
  
"""
Space Optimisation
"""

class Solution {
    
    static int knapSack(int val[], int wt[], int cap) {
        int n = val.length;
        int[] dp = new int[cap+1];
        for(int i = wt[0]; i<=cap; i++){
            dp[i] = val[0] * (i/wt[0]);
        }
        
        for(int i = 1; i<n; i++){
            int[] temp = new int[cap+1];
            for(int j = 0; j<=cap; j++){
                int nopick = dp[j];
                int pick = 0;
                if(j>=wt[i]){
                    pick = val[i] + temp[j-wt[i]];
                }
        
                temp[j] = Math.max(pick, nopick);
            }
            dp = temp;
        }
        return dp[cap];
    }
}
