"""
Approach

Based on usage of NSE and PSE
Simply calculating how many bars are higher or equal behind and upfront using PSE and NSE respectively 
Add and subtract 1 and multiply by heights[i] to get size
Check for max
"""
class Solution {

    static int[] pse(int[] heights, int n){
        int[] pse = new int[n];
        int[] s = new int[n];
        int top = -1;
        for(int i = 0; i<n; i++){
            while(top!=-1 && heights[s[top]]>heights[i]){
                top--;
            }
            pse[i] = top==-1? -1 : s[top];
            s[++top] = i;
        }
        return pse; 
    }

    static int[] nse(int[] heights, int n){
        int[] nse = new int[n];
        int[] s = new int[n];
        int top = -1;
        for(int i = n-1; i>=0; i--){
            while(top!=-1 && heights[s[top]]>=heights[i]){
                top--;
            }
            nse[i] = top==-1? n : s[top];
            s[++top] = i;
        }
        return nse; 
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = pse(heights,n);
        int[] nse = nse(heights,n);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int l = i - pse[i];
            int r = nse[i] - i;
            max = Math.max(max, (l+r-1)*heights[i]); //whole l,r could be replaced by nse-pse-1
        }
        return max;
    }
}
