// Same as 3Sum this time keep i static and j then move k from j+1 and l from end
// Then move j, then when j completes one cycle then move i

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        int n = nums.length;
        int i = 0;
        while (i < n - 3) {
            int j = i + 1;
            long sum = nums[i];
            while (j < n - 2) {
                int k = j + 1;
                int l = n - 1;
                sum += nums[j];
                while (k < l) {
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new LinkedList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        list.add(temp);
                        int a = nums[k];
                        int b = nums[l];
                        sum -= nums[k];
                        sum -= nums[l];
                        while (k < l && a == nums[k]) {
                            k++;
                        }
                        while (k < l && b == nums[l]) {
                            l--;
                        }
                    } else if (sum > target) {
                        sum -= nums[k];
                        sum -= nums[l];
                        l--;
                    } else {
                        sum -= nums[k];
                        sum -= nums[l];
                        k++;
                    }
                }
                sum -= nums[j];
                int c = nums[j];
                while (j < n - 2 && nums[j] == c) {
                    j++;
                }
            }
            int d = nums[i];
            while (i < n - 3 && nums[i] == d) {
                i++;
            }
        }
        return list;
    }
}
