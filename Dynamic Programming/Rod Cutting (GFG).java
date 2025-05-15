"""
Approach

Same Pick No Pick Also infinite inventory
"""

"""
Recursion
"""

class Solution {
    
    static int cut(int[] price, int i, int n){
        if(n==0) return 0;
        if(i==0) return n*price[i];
        
        int nopick = cut(price, i-1, n);
        int pick = Integer.MIN_VALUE;
        if(n>i){
            pick = price[i] + cut(price, i, n-i-1);
        }
        
        return Math.max(pick, nopick);
    }
    
    public int cutRod(int[] price) {
        return cut(price, price.length-1, price.length);
    }
}
  
"""
Recursion + Memoization
"""

class Solution {
    
    static int cut(int[] price, int i, int n, int[][] dp) {
        if(n==0) return 0;
        if(i==0) return n*price[i];
        
        if(dp[i][n]!=0) return dp[i][n];
        
        int nopick = cut(price, i-1, n, dp);
        int pick = Integer.MIN_VALUE;
        if(n>i){
            pick = price[i] + cut(price, i, n-i-1, dp);
        }
        
        return dp[i][n] = Math.max(pick, nopick);
    }
    
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        return cut(price, n-1, n, dp);
    }
}
  
"""
Tabulation
"""

class Solution {
    
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i<=n; i++){
            dp[0][i] = i * price[0];
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=n; j++){
                int nopick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(j >= i+1){
                    pick = price[i] + dp[i][j-i-1];
                }
                dp[i][j] = Math.max(pick, nopick);
            }
        }
        return dp[n-1][n];
    }
}
  
"""
Space Optimisation
"""

class Solution {
    
    public int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n+1];
        for(int i = 0; i<=n; i++){
            dp[i] = i * price[0];
        }
        for(int i = 1; i<n; i++){
            int[] temp = new int[n+1];
            for(int j = 0; j<=n; j++){
                int nopick = dp[j];
                int pick = Integer.MIN_VALUE;
                if(j >= i+1){
                    pick = price[i] + temp[j-i-1];
                }
                temp[j] = Math.max(pick, nopick);
            }
            dp = temp;
        }
        return dp[n];
    }
}
