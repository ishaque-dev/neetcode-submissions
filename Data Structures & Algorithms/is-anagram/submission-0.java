class Solution {
    public boolean isAnagram(String s, String t) {
         int[] charactorAt = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            charactorAt[s.charAt(i) - 'a']++;
            charactorAt[t.charAt(i) - 'a']--;
        }

        for (int i : charactorAt) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
