class Solution {
    public String minWindow(String s, String t) {
   if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        int created = 0;
        int[] answer = new int[] { -1, 0, 0 };
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int required = tMap.size();
        Map<Character, Integer> subStrMap = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            int count = subStrMap.getOrDefault(ch, 0);
            subStrMap.put(ch, count + 1);
            if (tMap.containsKey(ch) && tMap.get(ch).intValue() == subStrMap.get(ch).intValue()) {
                created++;
            }
            while (left <= right && created == required) {
                ch = s.charAt(left);
                if (answer[0] == -1 || answer[0] >= right - left + 1) {
                    answer[0] = right - left + 1;
                    answer[1] = left;
                    answer[2] = right;
                }
                subStrMap.put(ch, subStrMap.getOrDefault(ch, 0) - 1);
                if (tMap.containsKey(ch) && subStrMap.get(ch) < tMap.get(ch)) {
                    created--;
                }

                left++;
            }
            right++;
        }
        if (answer[0] == -1) {
            return "";
        } else {
            return s.substring(answer[1], answer[2] + 1);
        }
}
}