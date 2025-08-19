"""
Approach

You can only add a close bracket if there is atleast one open bracket so close-open>0
You can only add n open brackets
"""

class Solution {

    void genPar(int n, int open, int close, StringBuilder sb, List<String> ans){
        if(open==n && close==n){
            ans.add(sb.toString());
            return;
        }

        int len = sb.length();

        if(close<open){
            sb.append(')');
            genPar(n, open, close+1, sb, ans);
            sb.delete(len, len+1);
        }
        
        if(open<n){
            sb.append('(');
            genPar(n, open+1, close, sb, ans);
            sb.delete(len, len+1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        genPar(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }
}
