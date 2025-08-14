"""
Approach

2-pointer approach
As soon as right != left start moving left
If length comes to 3 check for max then move whole window upfront
"""

class Solution {
    public String largestGoodInteger(String num) {
        int left = 0;
        int right = 0;
        int n = num.length();
        String ans = "";
        char max = 46;
        char curr = 46;
        while(right<n){
            char r = num.charAt(right);
            while(r != num.charAt(left)){
                left++;
            }
            if(left==right) curr = num.charAt(right);
            if(right-left+1==3){
                if(max<curr){
                    max = curr;
                    ans = num.substring(left, right+1);
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
