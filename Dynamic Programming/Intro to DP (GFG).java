"""
Approach

In Bottom-Up, just maintain the last and second last fib numbers
In Top-Down, maintain a DP Array to store already calculated fib numbers
"""
class Solution {
    
    static final int MOD = 1000000007;

    static long topDown(int n, long[] dp){
        if(n==0 || n==1) return n;
        if(dp[n]==-1){
            dp[n] = ( topDown(n-1, dp)+topDown(n-2, dp) ) % MOD;
        }
        return dp[n];
    }

    static long topDown(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return topDown(n,dp);
    }

    static long bottomUp(int n) {
        if(n==0 || n==1) return n;
        long pre1 = 0;
        long pre2 = 1;
        long val = 0;
        for(int i = 2; i<=n; i++){
            val = ( pre2+pre1 ) % MOD;
            pre1 = pre2;
            pre2 = val;
        }
        return val;
    }
}
