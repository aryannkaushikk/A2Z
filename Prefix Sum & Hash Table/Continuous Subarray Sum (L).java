"""
Approach

Same as Subarray sum problem but here we are maintaining a sum%k in map and if that occurs again that means between index j and i where sum%k occured first and second time,
  there exists a subarray which has a sum%k==0
We add 0, -1 to detect modulo 0 but with length >= 2
"""

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int sum = 0;
        map.put(0,-1);
        for(int i = 0; i<n; i++){
            sum += nums[i];
            if(map.containsKey(sum%k) && i-map.get(sum%k)>1) return true;
            map.putIfAbsent(sum%k, i);
        }
        return false;
    }
}
