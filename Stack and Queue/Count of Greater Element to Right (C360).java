"""
Approach

Traversed from id+1 to n for each id in query to count greater elements
"""

public class Solution {
    public static int[] countGreater(int []arr, int []query) {
        int m = query.length;
        int n = arr.length;
        int[] ans = new int[m];
        for(int i = 0; i<m; i++){
            int count = 0;
            for(int j = query[i]+1; j<n; j++){
                if(arr[query[i]]<arr[j]){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
