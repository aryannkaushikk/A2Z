"""
Approach

We are using Sliding Window and 2-Pointer Mix here
We are keeping track of the last occurence index of each character
When we are at a character ch, except that one we check between other 2 which one occurred before
and from start to this leftMost character, the total substrings is the number of characters between
Why?
Because if lets say pointer came to 'a' and among all 3 'a' is leftMost then we dont need to consider it as we can still build valid substring using the current 'a'
but leftMost character 'b' or 'c' cant be deleted or substring goes invalid
So we are just seeing till which character can we delete the string from 0 and form multiple substrings
"""

class Solution {
    public int numberOfSubstrings(String s) {
        int a = -1;
        int b = -1;
        int c = -1;
        int count = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            int min = Integer.MAX_VALUE;
            if(ch=='a'){
                a = i;
                min = Math.min(b,c);
            }
            else if(ch=='b'){
                b = i;
                min = Math.min(a,c);
            } 
            else{
                c = i;
                min = Math.min(a,b);
            } 

            if(a+b+c>=3){
                count += min+1;
            }
        }

        return count;
    }
}
