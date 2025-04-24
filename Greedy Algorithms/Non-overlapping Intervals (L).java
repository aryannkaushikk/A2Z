"""
Approach

Exact opposite of N meetings
"""
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        int last = intervals[0][1];
        int count = 0;
        for(int i = 1; i<n; i++){
            if(intervals[i][0]>=last){
                last = intervals[i][1];
            }else{
                count++;
            }
        }
        return count;
    }
}
