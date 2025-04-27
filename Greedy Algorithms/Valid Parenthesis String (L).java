"""
Approach

We are carrying a range that tells us how much unpaired parenthesis can be if we used all combinations
If we get min as 0 then valid is possible
Every opening adds 1 closing subs 1
Asterisk decrease by 1 min and increase max by 1
If min go below 0 bring it to 0
If max go below then that means no possible way to make valid
"""

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0;
        int max = 0;
        for(int i = 0; i<n; i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }else if(s.charAt(i)==')'){
                min--;
                max--;
            }else{
                min -= 1;
                max += 1;
            }
            if(min<0){
                min = 0;
            }
            if(max<0){
                return false;
            }
        }
        if(min==0){
            return true;
        }
        return false;
    }
}
