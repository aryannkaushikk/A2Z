// Take lsum and rsum
// Initiate with sum of k values from left
// Then compare lsum+rsum for max value and keep subtracting last element of lsum and adding to rsum from last of array


class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int l = 0;
        int r = cardPoints.length-1;
        for(l = 0; l<k; l++){
            lsum += cardPoints[l];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<k; i++){
            if(lsum+rsum>max){
                max = lsum+rsum;
            }
            lsum -= cardPoints[--l];
            rsum += cardPoints[r--];
        }
        max = Math.max(max,lsum+rsum);
        return max;
    }
}
