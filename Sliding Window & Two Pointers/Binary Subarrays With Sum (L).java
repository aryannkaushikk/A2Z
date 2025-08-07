"""
Approach 1
  
Same as Number of Subarrays with Sum K
Use Prefix Sum HashMap
"""
  
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i<n; i++){
            sum += nums[i];
            count += map.getOrDefault(sum-goal, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}

"""
Approach 2

Use a function atMost which calculates number of arrays with Sum<=Goal
atMost(goal) - atMost(goal-1) will give arrays with sum goal only
Use simple two pointers for atMost move right and when sum>goal move left till sum>goal
"""

class Solution {

    public int atMost(int[] nums, int goal){
        if(goal<0) return 0;
        int left = 0;
        int sum = 0;
        int count = 0;
        for(int right = 0; right<nums.length; right++) {
            sum += nums[right];
            while(sum > goal){
                sum -= nums[left];
                left++;
            }
            count += right-left+1;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums ,goal) - atMost(nums, goal-1);
    }
}
