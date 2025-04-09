"""
Push for every opening bracket
Pop for every closing if it matches top of stack else false or if stack empty then false
if at end stack empty then true else false
"""

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char x = s.charAt(i);
            if((x==')' || x==']' || x=='}') && !st.isEmpty()){
                if(x==')' && st.peek()=='('){
                    st.pop();
                }
                else if(x=='}' && st.peek()=='{'){
                    st.pop();
                }
                else if(x==']' && st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(x);
            }
        }
        return st.isEmpty();
    }
}
