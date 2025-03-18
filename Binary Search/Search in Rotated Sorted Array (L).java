// Check Mid
// If mid not target then identify sorted half -> Left/Right
// If left sorted and target lies between low and mid then go left else right
// If right sorted and target lies between mid and high then go right else left

class Solution {

    public static int bs(int[] nums, int target, int i, int j){
        if(i>j){
            return -1;
        }
        int mid = (i+j)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]<nums[j]){
            if(nums[mid]<=target && target<=nums[j]){
                return bs(nums,target,mid+1,j);
            }else{
                return bs(nums,target,i,mid-1);
            }
        }else{
            if(nums[mid]>=target && target>=nums[i]){
                return bs(nums,target,i,mid-1);
            }else{
                return bs(nums,target,mid+1,j);
            }
        }
    }

    public int search(int[] nums, int target) {
        return bs(nums,target,0,nums.length-1);
    }
}
