"""
Approach

Same as Count Partitions as There will be two subsets Pos and Neg and Pos - Neg = Target
"""

"""
Recursion + Memoization
"""

class Solution {

    int count(int[] arr, int i, int sum, int[][]dp){
		if(i==0){
			if(sum==0 && arr[0]==0) return 2;
			if(sum==0 || sum==arr[0]) return 1;
			return 0;
		}

		if(dp[i][sum]!=-1) return dp[i][sum];

		int nopick = count(arr, i-1, sum, dp);
		int pick = 0;

		if(arr[i]<=sum){
			pick = count(arr, i-1, sum-arr[i], dp);
		}

		return dp[i][sum] = pick + nopick;
	}
    
    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int sum = 0;
		for(int i = 0; i<n; i++){
			sum += arr[i];
		}
		int tar = sum-d;
		if(tar<0) return 0;
		if(tar%2!=0) return 0;
		tar /= 2;
		int[][] dp = new int[n][tar+1];
		for(int i = 0; i<n; i++){
			Arrays.fill(dp[i], -1);
		}
		return count(arr, n-1, tar, dp);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums, target);
    }
}
