// Sort the array
// Starting i from 0
// j from i+1 and k from end
// if i+j+k==0 then add i,j,k to list
// then move j forward till you get a diff num and k backward till you get diff num
// If sum<0 move j ahead else move k backward by 1
// when the j,k loop is over for i
// Increase i to a diff num

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        int n = nums.length;
        int i = 0;
        while (i < n-2) {
            int j = i+1;
            int k = n-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    list.add(temp);
                    int a = nums[j];
                    int b = nums[k];
                    while(j<k && a==nums[j]){
                        j++;
                    }
                    while(j<k && b==nums[k]){
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            int x = nums[i];
            while(i<n-2 && x==nums[i]){
                i++;
            }
        }
        return list;
    }
}
