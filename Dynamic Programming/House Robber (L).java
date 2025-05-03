"""
Recursion
"""

class Solution {

    static int rob(int[] nums, int id){
        if(id==0) return nums[id];
        if(id<0) return 0;
        int pick = nums[id] + rob(nums, id-2, dp);
        int nopick = rob(nums,id-1, dp); 
        return Math.max(pick,nopick);
    }

    public int rob(int[] nums) {
        return rob(nums, nums.length-1, dp);
    }
}

"""
Recursion + Memoization
"""

class Solution {

    static int rob(int[] nums, int id, int[] dp){
        if(id==0) return nums[id];
        if(id<0) return 0;
        if(dp[id]!=-1) return dp[id];
        int pick = nums[id] + rob(nums, id-2, dp);
        int nopick = rob(nums,id-1, dp);
        dp[id] = Math.max(pick,nopick); 
        return dp[id];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1); 
        return rob(nums, nums.length-1, dp);
    }
}

"""
Tabulation
"""

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0]; 
        for(int i = 1; i<n; i++){
            int pick = nums[i];
            if(i>1) pick += dp[i-2];
            int nopick = dp[i-1];
            dp[i] = Math.max(pick,nopick);
        }
        return dp[n-1];
    }
}
  
"""
Space Optimisation
"""

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int pre1 = nums[0]; 
        int pre2 = 0;
        int value = nums[0];
        for(int i = 1; i<n; i++){
            int pick = nums[i] + pre2;
            int nopick = pre1;
            value = Math.max(pick,nopick);
            pre2 = pre1;
            pre1 = value;
        }
        return value;
    }
}
