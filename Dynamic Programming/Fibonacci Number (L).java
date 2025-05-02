"""
Approach

Store the value of nth fibonacci number in DP Array if not available but if available return that
"""
class Solution {

    public int fibo(int n, int[] dp){
        if(n==1 || n==0){
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        dp[n] = fibo(n-1,dp)+fibo(n-2,dp);
        return dp[n];
    }

    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibo(n,dp);
    }
}
