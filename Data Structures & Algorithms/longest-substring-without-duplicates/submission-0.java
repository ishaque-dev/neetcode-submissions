class Solution {
    public int lengthOfLongestSubstring(String s) {
           int left = 0;
        int length = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            while (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
