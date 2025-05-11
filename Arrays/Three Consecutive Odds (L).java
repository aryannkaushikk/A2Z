"""
Approach

If all 3 Odd return true
If less than 3 Odd then continue from the non Odd index+1
"""
  
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0; i<arr.length-2; i++){
            if(arr[i]%2!=0){
                int j = i+1;
                while(j<i+3 && arr[j]%2!=0){
                    j++;
                }
                if(j==i+3) return true;
                else i = j;
            }
        }
        return false;
    }
}
