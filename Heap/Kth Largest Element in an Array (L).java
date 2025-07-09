"""
Approach

Use min-heap (deafult PQ)

When size goes beyond k remove (min element)
So that in end when size is k the min element is kth largest
"""

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size()>k) pq.poll();
        }

        return pq.poll();
    }
}
