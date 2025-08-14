"""
Approach

Use two pointers and if whole s is traversed then true else false
"""

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if(sn==0) return true;
        if(tn<sn) return false;
        int sp = 0;
        int tp = 0;
        while(sp<sn && tp<tn){
            if(s.charAt(sp)==t.charAt(tp)) sp++;
            tp++;
        }
        return sp==sn ? true : false;
    }
}
