class Solution {
    public void moveZeroes(int[] nums) {
        int x = 0;
        while(x<nums.length && nums[x]!=0){
            x++;
        }
        if(x>=nums.length-1){
            return;
        }
        int i = x+1;
        while(i<nums.length){
            if(nums[i]!=0){
                nums[x] = nums[i];
                nums[i] = 0;
                x++;
            }
            i++;
        }
    }
}
