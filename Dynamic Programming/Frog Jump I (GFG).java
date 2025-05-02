"""
Approach

The minimum cost to reach n is from n-1 and n-2 so minimum cost to reach n-1 or n-2 + energy difference between n and n-1 OR n and n-2 is the answer
Use DP Array to store calculated minimum costs
Special case in calculating n-2 in n==1 cause cant reach n-2 so just return left
"""

"""
Recursion + Memoization
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

"""
Tabulation
"""

class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        for(int i = 1; i<n; i++){
            int fs = Math.abs(height[i]-height[i-1])+dp[i-1];
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = Math.abs(height[i]-height[i-2])+dp[i-2];
            }
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
        
    }
}

"""
Space Optimization
"""

class Solution {
    int minCost(int[] height) {
        int n = height.length;
        if(n==1) return 0;
        int[] dp = new int[n];
        int fs = Math.abs(height[1]-height[0]);
        int ss = 0;
        int val = 0;
        if(n==2) return fs;
        for(int i = 2; i<n; i++){
            int a = Math.abs(height[i]-height[i-1])+fs;
            int b = Integer.MAX_VALUE;
            if(i>1){
                b = Math.abs(height[i]-height[i-2])+ss;
            }
            val = Math.min(a,b);
            ss = fs;
            fs = val;
        }
        return val;
        
    }
}
