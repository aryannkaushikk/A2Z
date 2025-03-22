// Starting from the first row and col. We take the mid element and then if its not peak (checked by greaterEl) then we see its up,down,left,right values.
// We go left if left highest
// We go right if right highest
// We go down (row++) if down highest
// We go up (row--) if up highest

class Solution {

    public static boolean greaterEl(int[][] mat, int i, int j){
        if(i>0 && mat[i][j]<mat[i-1][j]){
            return false;
        }
        if(i<mat.length-1 && mat[i][j]<mat[i+1][j]){
            return false;
        }
        if(j>0 && mat[i][j]<mat[i][j-1]){
            return false;
        }
        if(j<mat[0].length-1 && mat[i][j]<mat[i][j+1]){
            return false;
        }
        return true;
    }

    public static int getUp(int[][] mat, int i, int j){
        if(i>0){
            return mat[i-1][j];
        }
        return -1;
    }

    public static int getDown(int[][] mat, int i, int j){
        if(i<mat.length-1){
            return mat[i+1][j];
        }
        return -1;
    }

    public static int getLeft(int[][] mat, int i, int j){
        if(j>0){
            return mat[i][j-1];
        }
        return -1;
    }

    public static int getRight(int[][] mat, int i, int j){
        if(j<mat[0].length-1){
            return mat[i][j+1];
        }
        return -1;
    }

    public int[] findPeakGrid(int[][] mat) {
        int[] ans = {-1,-1};
        int low = 0;
        int high = mat[0].length-1;
        for(int i = 0; i<mat.length && ans[0]==-1; i++){    
            while(low<=high){
                int mid = (low+high)/2;
                if(greaterEl(mat,i,mid)){
                    ans[0] = i;
                    ans[1] = mid;
                    return ans;
                }else{
                    int up = getUp(mat,i,mid);
                    int down = getDown(mat,i,mid);
                    int left = getLeft(mat,i,mid);
                    int right = getRight(mat,i,mid);

                    int max1 = Math.max(left,right);
                    int max2 = Math.max(down,up);
                    int max = Math.max(max1,max2);
                    
                    if(max==down){
                        break;
                    }else if(max==left){
                        high = mid-1;
                    }else if(max==right){
                        low = mid+1;
                    }else{
                        i-=2;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
