// Create separate arrays for rows and columns and store 1 at index where (row,column) is 0 in row and col array respectively.
// Then iterate again and if row index of current element is 1 in row array or same for column, set element to 0.
// There is another approach that uses first row and column of matrix only to save space.

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
