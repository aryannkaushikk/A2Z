// If mid is greater than its both neighbours then its a peak.
// Else you look into right if mid is less than mid+1
// Else you look left.

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        int n = nums.length;
        if(nums[n-1]>nums[n-2]){
            return n-1;
        }
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid]>nums[mid+1]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
