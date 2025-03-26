// Merge Sort based approach kinda hard to explain here


class Solution {
    
    public static int merge(int start, int mid, int end, int[] arr){
        int s = start;
        int e = mid+1;
        int count = 0;
        while(s<=mid && e<=end){
            if(arr[s]>arr[e]){
                count+=(mid-s+1);
                e++;
                continue;
            }else{
                s++;
            }
        }
        int[] merged = new int[end-start+1];
        int i = start, j = mid+1, k = 0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                merged[k++] = arr[i++];
            }
            else {
                merged[k++] = arr[j++];
            }
        }
        while(i<=mid){
            merged[k++] = arr[i++];
        }
        while(j<=end){
            merged[k++] = arr[j++];
        }
        for (k=0,i=start;k<merged.length;i++,k++) {
            arr[i] = merged[k];
        }
        return count;
    }

    public static int mergeSort(int start, int end, int[] arr){
        if(start==end){
            return 0;
        }
        int count = 0;
        int mid = (start+end)/2;
        count += mergeSort(start,mid,arr);
        count += mergeSort(mid+1,end,arr);
        count += merge(start,mid,end,arr);
        return count;
    }
    
    static int inversionCount(int arr[]) {
        return mergeSort(0,arr.length-1,arr);
    }
}
