"""
Approach 1

Based on prefixMax and postfixMax - calc them by iterating from front and rear
Then the amount of water stored at ith index is min(pre[i], post[i]) - arr[i]

I used array to store pre too but can optimise by calculating pre as we go 
Initially pre is arr[0]
"""

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = height[0];
        post[n-1] = height[n-1];
        for(int i = 1; i<n; i++){
            pre[i] = Math.max(pre[i-1],height[i]);
        }
        for(int i = n-2; i>=0; i--){
            post[i] = Math.max(post[i+1],height[i]);
        }
        int total = 0;
        for(int i = 0; i<n; i++){
            if(height[i]<pre[i] && height[i]<post[i]){
                total += Math.min(pre[i],post[i]) - height[i];
            }
        }
        return total;
    }
}


"""
Approach 2 ( TC = O(n) , SC = O(1) )

Two pointers l and r and two var of lMax and rMax 
If l<=r then water at l is lMax - l
Else same for r

l and r will always meet at the tallest tower and need not check min (lMax, rMax) as the other side will never have larger because we are operating on smaller ones first
"""

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int lMax = 0;
        int rMax = 0;
        int total = 0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]<lMax){
                    total += lMax - height[l];
                }
                lMax = Math.max(lMax, height[l]);
                l++;
            }else{
                if(height[r]<rMax){
                    total += rMax - height[r];
                }
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }
        return total;
    }
}
