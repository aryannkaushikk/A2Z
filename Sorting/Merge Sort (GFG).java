class Solution {
    
    static void merge(int[] arr, int l, int mid, int r){
        int[] merged = new int[r-l+1];
        int a = l;
        int b = mid+1;
        int i = 0;
        while(a<=mid && b<=r){
            if(arr[a]<=arr[b]){
                merged[i++] = arr[a++];
            }else{
                merged[i++] = arr[b++];
            }
        }
        while(a<=mid){
            merged[i++] = arr[a++];
        }
        while(b<=r){
            merged[i++] = arr[b++];
        }
        for(i = 0; i<merged.length; i++){
            arr[l++] = merged[i];
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}
