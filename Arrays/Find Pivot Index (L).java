"""
Approach

Use Postfix Sum
"""

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] post = new int[n];
        post[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--){
            post[i] = post[i+1] + nums[i];
        }
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            if(sum==post[i]) return i;
        }
        return -1;
    }
}
