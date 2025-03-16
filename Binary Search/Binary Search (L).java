class Solution {
    public static int bs(int[] nums, int i, int j, int target){
        if(i>j){
            return -1;
        }
        int mid = (i+j)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            return bs(nums,i,mid-1,target);
        }else{
            return bs(nums,mid+1,j,target);
        }
    }
    public int search(int[] nums, int target) {
        return bs(nums,0,nums.length-1,target);
    }
}
