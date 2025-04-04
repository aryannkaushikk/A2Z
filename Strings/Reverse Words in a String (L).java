Split the string
Iterate the array in reverse and if current element length is 0 dont add it else add and if current index is > 0 then add " "
Works for both String and StringBuilder but StringBuilder was faster

class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i].length()==0){
                continue;
            }
            ans.append(arr[i]);
            if(i>0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
