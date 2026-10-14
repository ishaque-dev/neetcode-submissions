class Solution {
    public String longestCommonPrefix(String[] strs) {
           if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int length = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || str.charAt(i) != ch) {
                  return  strs[0].substring(0, length);
                }
            }
            length++;
        }
        return strs[0].substring(0, length);     
    }
}