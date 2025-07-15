class Solution {

    public String encode(String s[]) {
        StringBuilder sb = new StringBuilder();
        for(String st: s){
            sb.append(st).append(",");
        }
        return sb.toString();
    }

    public String[] decode(String s) {
        String[] ans = s.split(",");
        return ans;
    }
}
