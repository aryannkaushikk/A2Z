"""
Approach

Since the array is already sorted we keep adding those intervals which already have end less than newInterval's start
Then when one appears where end is greater than newInterval's start there we have a possibility of merger till the coming end elements are less than or equal to newInterval's end\
Then add newInterval and rest of others
"""

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i<n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while(i<n){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
