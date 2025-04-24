"""
Approach

Simply sort the array and for 1 to n
Keep summing i-1 and add it to a total
AVG is total/n
"""
class Solution {
    static int solve(int bt[] ) {
        Arrays.sort(bt);
        int sum = 0;
        int n = bt.length;
        int total = 0;
        for(int i = 1; i<n; i++){
            sum+=bt[i-1];
            total += sum;
        }
        return total/n;
    }
}
