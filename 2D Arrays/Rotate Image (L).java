// Reverse Element in each column order.
// Then swap (i,j) value with (j,i) value.
// The second one gives you transpose of a matrix but since its rotating the column reversal is also required before it.

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<m/2; i++){
            for(int j = 0; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = temp;
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
