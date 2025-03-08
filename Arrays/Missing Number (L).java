class Solution {
    public int missingNumber(int[] nums) {
        int[] n = new int[nums.length];
        int i = 0;
        while(i<nums.length){
            if(nums[i]>n.length-1){
                i++;
                continue;
            }
            n[nums[i]] = 1;
            i++;
        }
        i = 0;
        while(i<n.length){
            if(n[i]==0){
                break;
            }
            i++;
        }
        return i;
    }
}
