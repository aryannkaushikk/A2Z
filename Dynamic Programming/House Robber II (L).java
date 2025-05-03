"""
Approach

Same as House Robber 1 just calculate from 0 to n-2 (excluding last) and 1 to n-1 (excluding first)
"""
class Solution {

    public int rob(int[] nums, int start, int last) {
        int pre1 = nums[start]; 
        int pre2 = 0;
        int value = nums[start];
        for(int i = start+1; i<last; i++){
            int pick = nums[i] + pre2;
            int nopick = pre1;
            value = Math.max(pick,nopick);
            pre2 = pre1;
            pre1 = value;
        }
        return value;
    }


    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int a = rob(nums, 0, n-1);
        int b = rob(nums, 1, n);
        return Math.max(a,b);
    }
}
