"""
Approach

We are using the logic of Largest Rectangle in Histogram Question
Row by Row compute prefix Sum of each column, sum turns to zero if element is 0
Then pass to largestRectangleArea function and check for max for each row 
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
            max = Math.max(max, (nse[i]-pse[i]-1)*heights[i]); //whole l,r could be replaced by nse-pse-1
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] pre = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]=='0'){
                    pre[j] = 0;
                }else{
                    pre[j] += matrix[i][j]-48;
                }
            }
            max = Math.max(max,largestRectangleArea(pre));
        }
        return max;
    }
}
