"""
Approach

Use the AtMostK Function where you count the number of arrays with distinct elements from 0-k
"""

class Solution {

    int atMostK(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int right = 0;
        int left = 0;
        while(right<n) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0)+1);

            while(freq.size()>k){
                int l = nums[left];
                freq.put(l, freq.get(l)-1);

                if(freq.get(l)==0) freq.remove(l);
                left++;
            }

            count += right-left+1;
            right++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k)-atMostK(nums, k-1);
    }
}
