"""
Approach

If sum till i is equal to k then count
If map contains sum-k then from where sum-k ended till i we have k sum
and we store how many times sum-k has occured
"""

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            sum += nums[i];
            if(sum==k) count++;
            if(map.containsKey(sum-k)) count+=map.get(sum-k);
            
            if(!map.containsKey(sum)) map.put(sum, 1);
            else map.put(sum, map.get(sum)+1);
        }

        return count;
    }
}
