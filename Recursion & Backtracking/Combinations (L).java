"""
Approach

At each index you can put values from last value used+1 till n-k (k is number of places left to be filled after this)
"""

class Solution {

    void backtrack(int i, int n, int k, List<Integer> list, List<List<Integer>> ans){
        if(k==-1){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int x = i+1; x<=n-k; x++){
            list.add(x);
            backtrack(x, n, k-1, list, ans);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, n, k-1, new ArrayList<>(), ans);
        return ans;
    }
}
