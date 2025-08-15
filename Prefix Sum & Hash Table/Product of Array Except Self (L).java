"""
Approach

Prefix and Suffix Product Array Usage
Where Prefix can be taken into just one variable
Idea is to get ith numbers 0->left side prod with prefix and n->right side product via suffix
and multiply them
"""

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int[] suffix = new int[n];
        for(int i = n-1; i>=0; i--){
            prod *= nums[i];
            suffix[i] = prod;
        }
        int[] ans = new int[n];
        prod = 1;
        for(int i = 0; i<n-1; i++){
            ans[i] = prod * suffix[i+1];
            prod *= nums[i];
        }
        ans[n-1] = prod;
        return ans;
    }
}
