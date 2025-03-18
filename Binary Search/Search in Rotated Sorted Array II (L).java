// The main catch in this question is duplicate values.
// And the answer also lies in it
// If the values are repeating in between array it is not really a problem our algo from previous question also works
// Problem is when both i and j hold same value but i!=j
// My solution is to shift either i or j one step ahead or behind respectively.
// That way you still have that element atleast once to compare and its duplicacy wont hinder when you compare mid element with i and j to check for sorted array part.

class Solution {

    public static boolean bs(int[] nums, int target, int i, int j){
        if(i>j){
            return false;
        }
        if(i!=j && nums[i]==nums[j]){
            return bs(nums,target,i+1,j);
        }
        int mid = (i+j)/2;
        if(nums[mid]==target){
            return true;
        }else if(nums[mid]<=nums[j]){
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

    public boolean search(int[] nums, int target) {
        return bs(nums,target,0,nums.length-1);
    }
}
