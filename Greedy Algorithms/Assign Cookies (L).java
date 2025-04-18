"""
Approach

Sort the greed and size array
Iterate from start of both till both not at end
If the current size is greater than or equal to cookie (greed) then move greed ahead, keep moving size 
"""
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int j = 0;
        int i = 0;
        while(i<n && j<m){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
