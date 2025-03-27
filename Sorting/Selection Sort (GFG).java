class Solution {
    void selectionSort(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            int j = i-1;
            int k = i;
            while(j>=0 && arr[j]>=arr[k]){
                int temp = arr[k];
                arr[k--] = arr[j];
                arr[j--] = temp;
            }
            
        }
    }
}
