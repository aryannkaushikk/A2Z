class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int e1 = 0;
        int e2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(c1==0 && nums[i]!=e2){
                e1 = nums[i];
                c1=1;
            }else if(c2==0 && nums[i]!=e1){
                e2 = nums[i];
                c2=1;
            }else if(nums[i]==e1){
                c1++;
            }else if(nums[i]==e2){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        List<Integer> list = new LinkedList<>();
        c1 = 0;
        c2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==e1){
                c1++;
            }else if(nums[i]==e2){
                c2++;
            }
        }
        if(c1>nums.length/3){
            list.add(e1);
        }
        if(c2>nums.length/3){
            list.add(e2);
        }
        return list;
    }
}
