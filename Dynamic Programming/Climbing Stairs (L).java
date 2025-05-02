"""
Approach

Exactly same as fibonacci numbers as to reach n, the number of ways are sum of ways to reach n-1 and n-2
"""
class Solution {
    public int climbStairs(int n) {
        if(n==1) return n;
        int p1 = 1;
        int p2 = 1;
        int val = 1;
        for(int i = 2; i<=n; i++){
            val = p1+p2;
            p1 = p2;
            p2 = val;
        }
        return val;
    }
}
