"""
Approach

Two Pointer + Prefix Sum Approach

Calc Prefix Sum from 0 -> k
Then keep subtracting rightmost element in left sum and add leftmost of right sum
Compare for max
"""

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0;
        for(int i = 0; i<k; i++){
            lsum += cardPoints[i];
        }
        int rsum = 0;
        int max = 0;
        max = Math.max(max, lsum+rsum);
        for(int i = 0; i<k; i++){
            lsum -= cardPoints[k-i-1];
            rsum += cardPoints[n-i-1];
            if(max<lsum+rsum) max = lsum+rsum;
        }
        return max;
    }
}
