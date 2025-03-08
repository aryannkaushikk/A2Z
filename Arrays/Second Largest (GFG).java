
class Solution {
    public int getSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        int max2 = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<max){
                max2 = Math.max(max2,arr[i]);
            }
        }
        return max2;
    }
}
