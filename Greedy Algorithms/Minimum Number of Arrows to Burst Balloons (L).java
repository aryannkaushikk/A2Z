"""
Approach

Sort by higher limits
For each balloon which has start <= high, keep going
else add a arrow and update high
"""

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int n = points.length;
        int count = 1;
        int upper = points[0][1];
        for(int i = 1; i<n; i++){
            int low = points[i][0];
            int high = points[i][1];
            if(low>upper){
                upper = high;
                count++;
            }
        }
        return count;
    }
}
