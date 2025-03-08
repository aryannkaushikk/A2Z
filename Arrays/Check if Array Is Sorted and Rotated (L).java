class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int j = 1;
        while(j<n){
            if(nums[j-1]>nums[j]){
                break;
            }
            j++;
        }
        if(j==n){
            return true;
        }
        while(j<n-1){
            if(nums[j]>nums[j+1] || nums[j]>nums[0]){
                return false;
            }
            j++;
        }
        if(j<n && nums[j]>nums[0]){
            return false;
        }
        return true;
    }
}
