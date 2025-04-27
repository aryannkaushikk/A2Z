"""
Approach

We sort in descending according to Value per Weight and Use from start till weight not empty or values not finished 
"""

class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        double[][] mix = new double[n][3];
        for(int i = 0; i<n; i++){
            mix[i][0] = values[i];
            mix[i][1] = weights[i];
            mix[i][2] = (double) values[i]/weights[i];
        }
        Arrays.sort(mix, (a,b)->{
            return Double.compare(b[2],a[2]);
        });
        double sum = 0;
        int i = 0;
        while(i<n){
            if(mix[i][1]>W){
                sum += mix[i][2]*W;
                break;
            }else{
                sum += mix[i][0];
                W -= mix[i][1];
            }
            i++;
        }
        return sum;
    }
}
