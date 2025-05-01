"""
Approach

Pick-No Pick used and list added to Nested List at end
"""
class Solution {
    public static void genSet(int[] nums, int curr, int n, List<Integer> list, List<List<Integer>> res){
        if(curr>=n){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[curr]);
        genSet(nums, curr+1, n, list, res);
        list.remove(list.size()-1);
        genSet(nums, curr+1, n, list, res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        genSet(nums, 0, nums.length, new ArrayList<>(), list);
        return list;
    }
}
