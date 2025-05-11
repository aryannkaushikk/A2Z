"""
Approach

Same as Subset Sum Equal Target but target is equal to (Sum of array) / 2
"""

"""
Recursion + Memoization
"""

class Solution {

    static boolean part(int[] nums, int i, int sum, Boolean[][] dp){
        if(sum==0) return true;
        if(i==0) return sum==nums[0];

        if(dp[i][sum] != null) return dp[i][sum];

        boolean nopick = part(nums, i-1, sum, dp);
        boolean pick = false;

        if(sum>=nums[i]){
            pick = part(nums, i-1, sum-nums[i], dp);
        }

        dp[i][sum] = pick || nopick;

        return dp[i][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        Boolean[][] dp = new Boolean[nums.length][(sum/2)+1];
        return part(nums, nums.length-1, sum/2, dp);
    }
}
