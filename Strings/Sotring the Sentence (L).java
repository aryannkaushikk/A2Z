Create array of same size as no. of words
Check the index of word by checking its last character and place in new array
Join the array of strings

class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] ans = new String[arr.length];
        for(int i = 0; i<arr.length; i++){
            int len = arr[i].length();
            int x = arr[i].charAt(len-1)-48;
            ans[x-1] = arr[i].substring(0,len-1);
        }
        return String.join(" ",ans);
    }
}
