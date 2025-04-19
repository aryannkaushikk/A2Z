class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int jumps = 0;
        while(r<n-1){
            int farthest = 0;
            for(int i = l; i<=r; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            jumps++;
            l = r+1;
            r = farthest;
        }
        return jumps;
    }
}
