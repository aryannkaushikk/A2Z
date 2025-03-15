// There is extra space provided in nums1 to accomodate m+n.
// This what we will base our approach on.
// Three pointers i at end of mth element, j at nth element and k at end of nums1.
// Compare i,j and place at k and decrease k and whichever was used.
// Do this till both i and j are greater than or equal to 0.
// Now if j==-1 then remaining are in nums1 and already in ascending order. 
// But if it isnt then remaining are in nums2 and need to place from j to 0 in k to 0.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        if(m==0){
            for(int i = 0; i<n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        if(j==-1){
            return;
        }else{
            while(k>=0){
                nums1[k--] = nums2[j--];
            }
        }
    }
}
