"""
Approach

Sliding Window
Decrease window till sum>=target
"""

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<n){
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return len==Integer.MAX_VALUE ? 0 : len;
    }
}
