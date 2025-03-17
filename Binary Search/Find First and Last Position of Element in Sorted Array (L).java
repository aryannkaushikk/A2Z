// If the mid element is equal to check for both arrays behind and forward
// else go forward if mid<target or go behind if mid>target

class Solution {
    
    static int[] ans;

    public static void bs(int[] nums, int target, int i, int j){
        if(i>j){
            return;
        }
        int mid = (i+j)/2;
        if(nums[mid]==target){
            if(ans[0]>mid){
                ans[0] = mid;
            }
            if(ans[1]<mid){
                ans[1] = mid;
            }
            bs(nums,target,i,mid-1);
            bs(nums,target,mid+1,j);
        }else if(nums[mid]>target){
            bs(nums,target,i,mid-1);
        }else{
            bs(nums,target,mid+1,j);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        ans = new int[2];
        ans[0] = nums.length;
        ans[1] = -1;
        bs(nums,target,0,nums.length-1);
        if(ans[0]==nums.length){
            ans[0] = -1;
        }
        return ans;
    }
}
