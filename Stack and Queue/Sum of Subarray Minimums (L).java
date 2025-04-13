"""
Approach

We are using NSE and PSE but not storing values instead the index at which those values were found.
Because then using PSE we are calculating the how many subarrays will have ith element as min in last and same using NSE for ith element as first in subarray
Their product gives total subarrays possible with ith as minimum and in total you add l*r*arr[i]
  
"""

class Solution {

    static int[] nse(int[] arr){
        int n = arr.length;
        int[] s = new int[n];
        int top = -1;
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            while(top!=-1 && arr[s[top]]>=arr[i]){
                top--;
            }
            ans[i] = top==-1? n : s[top];
            s[++top] = i;
        }
        return ans;
    }

    static int[] pse(int[] arr){
        int n = arr.length;
        int[] s = new int[n];
        int top = -1;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            while(top!=-1 && arr[s[top]]>arr[i]){
                top--;
            }
            ans[i] = top==-1? -1 : s[top];
            s[++top] = i;
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] pse = pse(arr);
        double total = 0;
        double mod = 1e9+7;
        for(int i = 0; i<arr.length; i++){
            int l = i-pse[i];
            int r = nse[i] - i;
            long x = l;
            x *= r;
            x *= arr[i];
            x %= mod;
            total = (total + x) % mod;
        }
        return (int) total;
    }
}
