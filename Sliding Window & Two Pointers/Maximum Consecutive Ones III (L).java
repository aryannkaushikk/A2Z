// Use a counter to allow number of 0s in the window if it exceeds k reduces window from back till counter is not < k again

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int max = 0;
        int counter = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                counter++;
            }
            while (counter > k) { 
                if (nums[l] == 0) {
                    counter--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
