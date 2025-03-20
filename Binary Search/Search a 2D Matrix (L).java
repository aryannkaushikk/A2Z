// Firstly two edge cases: If only 1 row or 1 column then normal binary search in columns or rows respectively.
// Now We find the mid of the whole matrix i.e. the mid of rows and cols. Then firstly according to mid element we do BS in current row
// Then apply same process for either rows above or rows below if target not found in current row.
  

class Solution {

    public static boolean bsRow(int[][] matrix, int col, int low, int high, int target){
        if(low>high){
            return false;
        }
        int mid = (low+high)/2;
        if(matrix[mid][col]==target){
            return true;
        }else if(matrix[mid][col]>target){
            return bsRow(matrix,col,low,mid-1,target);
        }else{
            return bsRow(matrix,col,mid+1,high,target);
        }
    }

    public static boolean bsCol(int[][] matrix, int row, int low, int high, int target){
        if(low>high){
            return false;
        }
        int mid = (low+high)/2;
        if(matrix[row][mid]==target){
            return true;
        }else if(matrix[row][mid]>target){
            return bsCol(matrix,row,low,mid-1,target);
        }else{
            return bsCol(matrix,row,mid+1,high,target);
        }
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int rowMin = 0;
        int rowMax = matrix.length-1;
        int colMin = 0;
        int colMax = matrix[0].length-1;
        if(rowMin==rowMax){
            return bsCol(matrix,rowMin,colMin,colMax,target);
        }
        if(colMin==colMax){
            return bsRow(matrix,colMin,rowMin,rowMax,target);
        }
        while(rowMin<=rowMax && colMin<=colMax){
            int rowMid = (rowMin+rowMax)/2;
            int colMid = (colMin+colMax)/2;
            int mid = matrix[rowMid][colMid];
            if(mid==target){
                return true;
            }else if(mid<target){
                if(bsCol(matrix,rowMid,colMid+1,colMax,target)){
                    return true;
                }
                rowMin = rowMid+1;
            }else{
                if(bsCol(matrix,rowMid,colMin,colMid-1,target)){
                    return true;
                }
                rowMax = rowMid-1;
            }
        }
        return false;
    }
}
