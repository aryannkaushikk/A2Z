"""
Approach

The minimum cost to reach n is from n-1 and n-2 so minimum cost to reach n-1 or n-2 + energy difference between n and n-1 OR n and n-2 is the answer
Use DP Array to store calculated minimum costs
Special case in calculating n-2 in n==1 cause cant reach n-2 so just return left
"""
class Solution {
    
    static int jump(int n, int[] height, int[] dp){
        if(n==0) return 0;
        
        if(dp[n]!=0) return dp[n];
        
        int left =  Math.abs(height[n]-height[n-1]) + jump(n-1,height, dp);
        int right = Integer.MAX_VALUE;
        if(n>1){
            right =  Math.abs(height[n]-height[n-2]) + jump(n-2,height, dp);
        }
        dp[n] = Math.min(left,right);
        return dp[n];
    }
        
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        return jump(n-1, height, dp);
    }
}
