// If the array bounds are sorted i.e. nums[i]<=nums[j] then array is sorted you return nums[i] (min element).
// Else a minimum element at index id in a rotated sorted array will be the one that is less than both nums[id-1] and nums[id+1].
// But if mid element is not minimum then you check which part is sorted left or right and go into the unsorted part since after rotation your min element got lost in that part only.

class Solution {

    public static int bs(int[] nums, int i, int j){
        if(i>j){
            return -1;
        }
        int mid = (i+j)/2;
        if(nums[i]<=nums[j]){
            return nums[i];
        }
        if(mid-1>=0 && mid+1<nums.length && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
            return nums[mid];
        }else if(mid-1>=0 && mid+1>=nums.length && nums[mid]<nums[mid-1]){
            return nums[mid];
        }else if (mid-1<0 && mid+1<nums.length && nums[mid]<nums[mid+1]){
            return nums[mid];
        }else if (nums[i]<=nums[mid]){
            return bs(nums,mid+1,j);
        }else{
            return bs(nums,i,mid-1);
        }
    }

    public int findMin(int[] nums) {
        return bs(nums,0,nums.length-1);
    }
}
