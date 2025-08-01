"""
Approach

If sum>target decrease sum by going to lower value from end
else if sum<target increase sum by going to higher value from start
else sum==target
"""

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int[] ans = new int[2];
        while(i<j) {
            int sum = nums[i]+nums[j];
            if(sum==target){
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }else if(sum<target){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
}
