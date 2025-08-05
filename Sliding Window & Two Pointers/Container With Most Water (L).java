"""
Approach

Use 2 pointers from both ends
And move the pointer each time which has minimum height
So we converge on the max possible container
"""

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        while(left < right) {
            if(height[left]<height[right]){
                max = Math.max(max, height[left]*(right-left));
                left++;    
            }else{
                max = Math.max(max, height[right]*(right-left));
                right--;
            }
        }
        return max;
    }
}
