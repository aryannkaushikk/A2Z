class Solution {

    List<List<Character>> alpha;

    void builder(char[] digits, int index, StringBuilder sb, List<String> ans){
        if(index==digits.length){
            ans.add(sb.toString());
            return;
        }

        int n = sb.length();

        for(char c : alpha.get(digits[index]-50)){
            sb.append(c);
            builder(digits, index+1, sb, ans);
            sb.delete(n, n+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        char[] arr = digits.toCharArray();
        alpha = new ArrayList<>();
        int x = 97;
        for(int i = 0; i<8; i++){
            List<Character> list = new ArrayList<>();
            if(i==5 || i==7){
                for(int j = 0; j<4; j++){
                    list.add((char) x++);
                }
            }else{
                for(int j = 0; j<3; j++){
                    list.add((char) x++);
                }
            }
            alpha.add(list);
        }
        List<String> ans = new ArrayList<>();
        builder(arr, 0, new StringBuilder(), ans);
        return ans;
    }
}
