"""
Approach

Need to a DS that can pop and push from both ends
So we are using a Deque (Double Ended Queue)
Elements are popped from Last till last element is not greater than current
Then First element is maximum of that window
Then remove First element till the index of first comes under the range of i to i-k
Then repeat popping from Last and add your current element at last
Then again first element is maximum of each window
"""
class Solution {

    static class Pair {
        int id;
        int val;

        public Pair(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Pair> s = new ArrayDeque<>();
        int i = 0;
        while (i < k) {
            while (!s.isEmpty() && s.getLast().val < nums[i]) {
                s.removeLast();
            }
            s.addLast(new Pair(i, nums[i]));
            i++;
        }
        ans[0] = s.getFirst().val;
        for (int j = i; j < n; j++) {
            while (!s.isEmpty() && s.getFirst().id <= j - k) {
                s.removeFirst();
            }
            while (!s.isEmpty() && s.getLast().val < nums[i]) {
                s.removeLast();
            }
            s.addLast(new Pair(i, nums[i]));
            i++;
            ans[i - k] = s.getFirst().val;
        }
        return ans;
    }
}
