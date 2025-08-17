"""
Approach

At each index stage (or list size stage) when you send off a number store in list store it in a set to not send it again no matter if it is from different index
"""

class Solution {

    void backtrack(int[] nums, int[] picked, List<Integer> list, List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        int[] set = new int[21];

        for(int i = 0; i<nums.length; i++){
            if(picked[i]==1) continue;
            if(set[nums[i]+10]==1) continue;
            picked[i] = 1;
            set[nums[i]+10] = 1;
            list.add(nums[i]);
            backtrack(nums, picked, list, ans);
            list.remove(list.size()-1);
            picked[i] = 0;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new int[nums.length], new ArrayList<>(), ans);
        return ans;
    }
}
