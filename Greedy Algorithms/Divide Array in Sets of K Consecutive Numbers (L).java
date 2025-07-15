"""
Approach

Sane as Hands of Straight use HashMap + Sorting and decrease frequency with frequency of starting value of each group
"""

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        if(n%k!=0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        Arrays.sort(nums);

        for(int i: nums){
            int count = map.get(i);
            if(count > 0) {
                for(int j = 0; j<k; j++){
                    int freq = map.getOrDefault(i+j, 0);
                    if(freq < count) return false;
                    map.put(i+j, freq-count);
                }
            }
        }

        return true;
    }
}
