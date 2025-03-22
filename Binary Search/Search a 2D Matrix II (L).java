// Start from bottom left corner and minus row or plus columns by comparing to target.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        int colMax = matrix[0].length;
        while(col<colMax && row>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                row--;
            }else{
                col++;
            }
        }
        return false;
    }
}
