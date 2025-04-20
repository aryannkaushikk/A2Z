"""
Approach

Since we are greedy about profit (MAX PROFIT)
Join the arrays into a matrix
and then Sort it according to profit in descending
Then Create array of size of deadline (doesnt matter)
For each deadline try to see if there is a empty slot to do it from the deadline-1 to 0
If yes add profit
"""

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] mix = new int[n][2];
        for(int i = 0; i<n; i++){
            mix[i][0] = deadline[i];
            mix[i][1] = profit[i];
        }
        Arrays.sort(mix, (a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        int count = 0;
        int prof = 0;
        for(int i = 0; i<n; i++){
            int x = mix[i][0];
            while(x>0 && vis[x-1]!=-1) x--;
            if(x>0){
                count++;
                prof += mix[i][1];
                vis[x-1] = mix[i][1];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(count);
        list.add(prof);
        return list;
    }
}
