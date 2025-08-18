"""
Approach

Simply moving from 1->9
Pick-Nopick at each step
Only adding when k==0 && n==0 (k numbers used and sum==n)
Base case n<3 || n>45 return empty list because of constraints sum of numbers being used one will never be out of range [3,45]
"""

class Solution {

    void backtrack(int i, int k, int n, List<Integer> list, List<List<Integer>> ans){
        if(k==0){
            if(n==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(i>9) return;

        backtrack(i+1, k, n, list, ans);
        if(n-i>=0){
            list.add(i);
            backtrack(i+1, k-1, n-i, list, ans);
            list.remove(list.size()-1);
        }else{
            return;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n<3 || n>45) return ans;
        backtrack(1, k, n, new ArrayList<>(), ans);
        return ans;
    }
}
