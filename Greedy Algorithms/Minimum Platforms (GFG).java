"""
Approach

If each Arrival and Departure are in alternating order if combined in ascending then we need only one platform
Every Arrival increase the count departure decrease it
So sort arrival and departure and iterate over both if arr is less c++ else c--
Return max c
"""
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxCount = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                count++;
                maxCount = Math.max(count, maxCount);
                i++;
            }else{
                count--;
                j++;
            }
        }
        return maxCount;
    }
}
