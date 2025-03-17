Simply return lower bound or i when limits cross i.e. element not found.
Because at arr[0] i will stay at 0 when j goes -1 (crosses it) and at arr[length-1] i will be at length when j crosses it.
  
class Solution {

    public static int sInsert(int[] nums, int target, int i, int j) {
        if (i > j) {
            return i;
        }
        int mid = (i + j) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return sInsert(nums, target, i, mid - 1);
        } else {
            return sInsert(nums, target, mid + 1, j);
        }
    }

    public int searchInsert(int[] nums, int target) {
        return sInsert(nums, target, 0, nums.length - 1);
    }
}
