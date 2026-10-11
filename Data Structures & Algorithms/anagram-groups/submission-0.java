class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
           if (strs.length == 0) {
            return new ArrayList<>();
        }
        int[] count = new int[26];
        Map<String, List<String>> ansMap = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i : count) {
                stringBuilder.append("#");
                stringBuilder.append(i);
            }
            String key = stringBuilder.toString();
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());

            }
            ansMap.get(key).add(str);

        }
        return new ArrayList<>(ansMap.values());
    }
}
