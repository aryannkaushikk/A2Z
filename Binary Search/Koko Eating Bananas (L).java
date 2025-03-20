// Find the max element and then between range 1-max try to find a value using BS which when it divides whole array and sums values gives you sum<=h. If yes try for lower, if no go for higher.

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = -1;
        for(int i = 0; i<piles.length; i++){
            if(piles[i]>high){
                high = piles[i];
            }
        }
        int low = 1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            long sum = 0;
            for(int i = 0; i<piles.length; i++){
                sum += (long) Math.ceil((double) piles[i]/mid);
            }
            if(sum<=h){
                ans = Math.min(ans,mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
