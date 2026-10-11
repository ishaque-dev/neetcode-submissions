class Solution {

    public String encode(List<String> strs) {
          String seperator = Character.toString((char) 258);
        if (strs.isEmpty()) {
            return seperator;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strs) {
            stringBuilder.append(string);
            stringBuilder.append(Character.toString((char) 257));
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
          String seperator = Character.toString((char) 257);
        if (str.equals(Character.toString((char) 258))) {
            return new ArrayList<>();
        }
        return Arrays.asList(str.split(seperator, -1));
    }
}
