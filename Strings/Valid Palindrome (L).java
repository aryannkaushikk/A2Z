// Two Pointers at start and end skip the index if char at index is not alphanumeric

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int i = 0;
        int j = n-1;
        while (i<j) {
            int x = (int) s.charAt(i);
            int y = (int) s.charAt(j);
            if(!(x>=97 && x<=122) && !(x>=48 && x<=57)){
                i++;
                continue;
            }
            if(!(y>=97 && y<=122) && !(y>=48 && y<=57)){
                j--;
                continue;
            }
            if(x!=y){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
}
