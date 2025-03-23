// Assuming nums1 is shorter than nums2 else recursive call with interchanged arguements.
// We see how many elements we take from nums1 and remaining from nums2 satsifies the equation l1<=r2 && l2<=r1, if l1>r2 that means we need to shift more elements of nums1 to right so high = mid1-1 else low = mid1+1

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int length = n1 + n2;
        int numsLeft = (n1 + n2 + 1) / 2;

        if (n1 <= n2) {
            int low = 0;
            int high = n1;
            while (low <= high) {
                int mid1 = (low + high) / 2;
                int mid2 = numsLeft - mid1;

                int l1 = Integer.MIN_VALUE;
                if (mid1 > 0) {
                    l1 = nums1[mid1 - 1];
                }
                int r1 = Integer.MAX_VALUE;
                if(mid1<n1){
                    r1 = nums1[mid1];
                }
                
                
                int l2 = Integer.MIN_VALUE;
                if (mid2 > 0) {
                    l2 = nums2[mid2 - 1];
                }
                int r2 = Integer.MAX_VALUE;
                if(mid2<n2){
                    r2 = nums2[mid2];
                }


                if (l1 <= r2 && l2 <= r1) {
                    int l = Math.max(l1, l2);
                    int r = Math.min(r1, r2);
                    if (length % 2 == 0) {
                        return (double) (l + r) / 2;
                    }
                    return (double) l;
                } else if (l1 > r2) {
                    high = mid1 - 1;
                } else {
                    low = mid1 + 1;
                }
            }

        } else {
            return findMedianSortedArrays(nums2,nums1);
        }
        return 0;
    }
}
