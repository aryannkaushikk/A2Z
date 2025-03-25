// Just try to find the first number from last <9 if last number is 9
// Add 1 to it after making everything after it 0
// In case you go out of bound while doing 0, it means create arrays of size+1 and make arr[0] = 1

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1]<9){
            digits[n-1]++;
            return digits;
        }else{
            int x = n-1;
            while(x>=0 && digits[x]==9){
                digits[x] = 0;
                x--;
            }
            if(x==-1){
                int[] ans = new int[n+1];
                ans[0] = 1;
                return ans;
            }else{
                digits[x]++;
                return digits;
            }
        }
    }
}
