"""
Approach

Use HashMap or Array
"""

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] map = new int[101];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, ++map[nums[i]]);
        }
        int count = 0;
        for(int i = 1; i<=100; i++){
            if(map[i]==max) count++;
        }
        
        return count*max;
    }
}
