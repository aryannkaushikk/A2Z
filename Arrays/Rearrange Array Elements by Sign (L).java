// An array of same size.
// You iterate in original while maintaining two pointers p and n in new array since they have to be alternate p = 0 and i = 1 initialliy and when u fill the place they move by +2.
// Iterate original array and fill at p if number>0 and move it else fill at n and move it. 

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int l = nums.length;
        int p = 0;
        int n = 1;
        int[] res = new int[l];
        for(int i = 0; i<l; i++){
            if(nums[i]>0){
                res[p] = nums[i];
                p+=2;
            }else{
                res[n] = nums[i];
                n+=2;
            }
        }
        return res;
    }
}
