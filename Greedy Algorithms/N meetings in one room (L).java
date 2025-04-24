"""
Approach

Create a array to combine start,end if not available
Sort the mix array on basis of end
We need to start counting from those meetings that will end early
So maintain a var last which will be first meetings end time and count = 1 (Cause at start meeting room will always be empty)
Then from there if next meeting start time is greater than last it can happen (count++) and also last = meeting[i][1] (new meeting's end time)
"""
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int[][] mix = new int[n][2];
        for(int i = 0; i<n; i++){
            mix[i][0] = start[i];
            mix[i][1] = end[i];
        }
        Arrays.sort(mix, (a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        int count = 1;
        int last = mix[0][1];
        for(int i = 1; i<n; i++){
            if(mix[i][0]>last){
                count++;
                last = mix[i][1];
            }
        }
        return count;
    }
}
