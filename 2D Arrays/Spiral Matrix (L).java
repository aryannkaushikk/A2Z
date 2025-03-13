class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int rmin = 0;
        int rmax = m-1;
        int cmin = 0;
        int cmax = n-1;
        int size = m*n;
        while(size>0){
            for(int i = cmin; i<=cmax; i++){
                list.add(matrix[rmin][i]);
                size--;
            }
            if(size==0){
                break;
            }
            rmin++;
            for(int i = rmin; i<=rmax; i++){
                list.add(matrix[i][cmax]);
                size--;
            }
            if(size==0){
                break;
            }
            cmax--;
            for(int i = cmax; i>=cmin; i--){
                list.add(matrix[rmax][i]);
                size--;
            }
            if(size==0){
                break;
            }
            rmax--;
            for(int i = rmax; i>=rmin; i--){
                list.add(matrix[i][cmin]);
                size--;
            }
            if(size==0){
                break;
            }
            cmin++;
        }
        return list;
    }
}
