"""
Approach

Maintaining a array to keep in check which ones have already been used and then using all others in the current index place
"""

class Solution {

    void backtrack(int[] nums, int[] picked, List<Integer> list, List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(picked[i]==1) continue;
            list.add(nums[i]);
            picked[i] = 1;
            backtrack(nums, picked, list, ans);
            list.remove(list.size()-1);
            picked[i] = 0;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new int[nums.length], new ArrayList<>(), ans);
        return ans;
    }
}
