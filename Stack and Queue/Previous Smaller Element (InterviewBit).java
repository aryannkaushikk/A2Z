"""
Same as Next Greater I just start from left and for smaller element
"""
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int n = A.size();
        int[] s = new int[n];
        int top = -1;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            while(top!=-1 && s[top]>=A.get(i%n)){
                top--;
            }
            if(i<n){
                ans[i] = top==-1 ? -1 : s[top];
            }
            s[++top] = A.get(i%n);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<n; i++){
            res.add(ans[i]);
        }
        return res;
    }
}
