"""
Approach

Sort the trainer and players and find min possible trainer for each player in ascending
"""

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int n = players.length, m = trainers.length;

        int i = 0;
        int j = 0;   
        int count = 0;
        while(i<n && j<m){
            if(players[i]<=trainers[j]){
                i++;
                count++;
            }
            j++;
        }

        return count;
    }
}
