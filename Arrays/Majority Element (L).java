class Solution {
    public int majorityElement(int[] nums) {
        int el = 0;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(count==0){
                el = nums[i];
            }
            if(nums[i]==el){
                count++;
            }else{
                count--;
            }
        }
        return el;
    }
}
