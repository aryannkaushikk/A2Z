"""
Approach 1

We are using the logic of Sum of Subarray minimums
We are producing Sum of Subarray minimums using pse and nse AND Sum of Subarray maximums using psg and nsg
So Maximums give us each element as max in number of subarrays and Minimums give us each element as min in number of subarrays
Then simply large-small give the range 
So Summation of large - Summation of small
Large is by Sum of Subarray Maximums
Small is by Sum of Subarray Minimums
"""

class Solution {

    static int[] pse(int[] arr, int n){
        int[] pse = new int[n];
        int[] s = new int[n];
        int top = -1;
        for(int i = 0; i<n; i++){
            while(top!=-1 && arr[s[top]]>arr[i]){
                top--;
            }
            pse[i] = top==-1 ? -1 : s[top];
            s[++top] = i;
        }
        return pse;
    }

    static int[] psg(int[] arr, int n){
        int[] psg = new int[n];
        int[] s = new int[n];
        int top = -1;
        for(int i = 0; i<n; i++){
            while(top!=-1 && arr[s[top]]<arr[i]){
                top--;
            }
            psg[i] = top==-1 ? -1 : s[top];
            s[++top] = i;
        }
        return psg;
    }

    static int[] nse(int[] arr, int n){
        int[] nse = new int[n];
        int[] s = new int[n];
        int top = -1;
        for(int i = n-1; i>=0; i--){
            while(top!=-1 && arr[s[top]]>=arr[i]){
                top--;
            }
            nse[i] = top==-1 ? n : s[top];
            s[++top] = i;
        }
        return nse;
    }

    static int[] nsg(int[] arr, int n){
        int[] nsg = new int[n];
        int[] s = new int[n];
        int top = -1;
        for(int i = n-1; i>=0; i--){
            while(top!=-1 && arr[s[top]]<=arr[i]){
                top--;
            }
            nsg[i] = top==-1 ? n : s[top];
            s[++top] = i;
        }
        return nsg;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] pse = pse(nums,n);
        int[] nse = nse(nums,n);
        int[] psg = psg(nums,n);
        int[] nsg = nsg(nums,n);
        long sum = 0;
        for(int i = 0; i<n; i++){
            long gl = i - psg[i];
            long gr = nsg[i] - i;
            long sl = i - pse[i];
            long sr = nse[i] - i;
            long large = gl*gr;
            long small = sl*sr;
            sum += (large-small)*nums[i];
        }
        return sum;
    }
}
