"""
Approach

For each number you go through use it as a index and negate value on that index
If you come again at a alreay negative value
Add it
"""

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                res.add(Math.abs(num));
            } else {
                nums[idx] = -nums[idx];
            }
        }
        
        return res;
    }
}
