"""
Approach

We are simply trying every sum possible using pick-nopick
Also we can pick same element more than once pick is called with same index

An optimisation is sort the array and prune the branch if current candidate[i] > target
No more of the elements from here will be useful
"""

class Solution {

    void backtrack(int[] candidates, int i, int target, List<List<Integer>> ans, List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>=candidates.length) return;

        backtrack(candidates, i+1, target, ans, list);
        if(target-candidates[i]>=0){
            list.add(candidates[i]);
            backtrack(candidates, i, target-candidates[i], ans, list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }
}
