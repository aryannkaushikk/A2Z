"""
Approach

Slope Approach
"""

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1;
        int i = 1;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum++;
                i++;
                continue;
            }
            int up = 1;
            while(i<n && ratings[i]> ratings[i-1]){
                up++;
                sum += up;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i]< ratings[i-1]){
                sum += down;
                down++;
                i++;
            }
            if(down > up){
                sum += down-up;
            }
        }
        return sum;
    }
}
