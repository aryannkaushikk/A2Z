"""
Approach

Sort the array 
Then at each index include the current index but after that only call those nums which are not repeated i.e. nums[i]!=nums[i-1]
"""

class Solution {

    void backtrack(int[] nums, int index, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        for(int i = index; i<nums.length; i++){
            
            if(i>index && nums[i]==nums[i-1]) continue;

            list.add(nums[i]);
            backtrack(nums, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}
