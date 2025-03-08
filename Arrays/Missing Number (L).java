// class Solution {
//     public int missingNumber(int[] nums) {
//         int[] n = new int[nums.length];
//         int i = 0;
//         while(i<nums.length){
//             if(nums[i]>n.length-1){
//                 i++;
//                 continue;
//             }
//             n[nums[i]] = 1;
//             i++;
//         }
//         i = 0;
//         while(i<n.length){
//             if(n[i]==0){
//                 break;
//             }
//             i++;
//         }
//         return i;
//     }
// }

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = 0;
        for(int i = 0; i<n; i++){
            x = x^nums[i]^i;
        }
        return x^n;
    }
}
