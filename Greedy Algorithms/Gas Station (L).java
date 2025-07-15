"""
Approach

We are trying to start from a index where cost<=gas, else keeping moving to next index
When you reach one such index iterate each index in circular order to see you can reach all indexes
"""

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasSum = 0;
        int costSum = 0;
        for(int i = 0; i<n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if(gasSum<costSum) return -1;
        int id = 0;
        while(id<n) {
            int count = 0;
            int curr = id;
            int currGas = 0;
            while(count<n){
                currGas += gas[curr];
                if(currGas<cost[curr]){
                    id = curr+1;
                    break;
                }
                currGas -= cost[curr];
                curr++;
                count++;
                if(curr==n) curr = 0;
            }
            if(count==n) return id;
        }

        return -1;
    }
}
