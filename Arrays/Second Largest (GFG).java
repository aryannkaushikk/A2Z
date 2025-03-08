
class Solution {
    public int getSecondLargest(int[] arr) {
        int max = arr[0];
        int max2 = -1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i]>max){
                max2 = max;
                max = arr[i];
            }else if(arr[i]>max2 && arr[i]<max){
                max2 = arr[i];
            }
        }
        return max2;
    }
}
