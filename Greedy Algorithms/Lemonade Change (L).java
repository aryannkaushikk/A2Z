"""
Approach

Keep Track of 5 and 10 denominations
If 10 you need atleast 1 five
If 20 need either 1-10 1-5 or 3-5
Check for 1-10 1-5 first as you get to keep more five notes in that choice (greedy) 
"""

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[2];
        int n = bills.length;
        for(int i = 0; i<n; i++){
            if(bills[i]==10){
                if(arr[0]>0){
                    arr[0]--;
                    arr[1]++;
                }else{
                    return false;
                }
            }
            else if (bills[i]==20){
                if(arr[1]>0 && arr[0]>0){
                    arr[1]--;
                    arr[0]--;
                }else if(arr[0]>=3){
                    arr[0] -= 3;
                }
                else{
                    return false;
                }
            }else{
                arr[0]++;
            }
        }
        return true;
    }
}
