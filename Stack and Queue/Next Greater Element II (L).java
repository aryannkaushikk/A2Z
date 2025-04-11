"""
Since the array is iterated in kinda circular method
We iterate from right but kind of twice 
We iterate from 2*n - 1 to 0 
and perform same as First part
But only when i is less than n we store in ans array
"""

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        int[] s = new int[n];
        int k = -1;
        for(int i = 2*n-1; i>=0; i--){
            while(k!=-1 && s[k]<=nums[i%n]){
                k--;
            }
            if(i<n){
                ans[i] = k==-1 ? -1 : s[k];
            }
            s[++k] = nums[i%n];
        }
        return ans;
    }
}
