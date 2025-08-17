"""
Approach

Convert whole String to StringBuilder
At each index if current character is not a digit
setCharAt(index) to Upper if lower
setCharAt(index) to Lower if upper
one call as it is regardless
"""

class Solution {

    void lcp(int i, StringBuilder sb, List<String> ans){
        if(i==sb.length()){
            ans.add(sb.toString());
            return;
        }
        int n = sb.length();
        char c = sb.charAt(i);
        
        
        lcp(i+1, sb, ans);

        if(c>=97){
            sb.setCharAt(i, Character.toUpperCase(c));
            lcp(i+1, sb, ans);
        }else if(c>=65){
            sb.setCharAt(i, Character.toLowerCase(c));
            lcp(i+1, sb, ans);
        }
        sb.setCharAt(i, c);
    }


    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        lcp(0, new StringBuilder(s), ans);
        return ans;
    }
}
