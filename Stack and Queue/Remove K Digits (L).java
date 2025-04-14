"""
Approach

We are popping from stack till stack not empty and top is greater than current
Then remove last k element if k not 0
Then remove trailing zeroes in start
If removal of zeroes remove whole stack return 0
Else return String from start to top
"""

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k==n){
            return "0";
        }
        char[] s = new char[n];
        int top = -1;
        for(int i = 0; i<n; i++){
            while(top!=-1 && k!=0 && s[top]-'0'>num.charAt(i)-'0'){
                top--;
                k--;
            }
            s[++top] = num.charAt(i);
        }
        top-=k;
        int i = 0;
        while(i<=top && s[i]=='0'){
            i++;
        }
        if(i>top){
            return "0";
        }
        return new String(s,i,top-i+1); //top-i+1 is giving number of elements from i in stack s
    }
}
