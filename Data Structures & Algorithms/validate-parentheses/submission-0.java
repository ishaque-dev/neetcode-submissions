class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        charMap.put('{', '}');
        charMap.put('(', ')');
        charMap.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.keySet().contains(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else if (stack.isEmpty() || charMap.get(stack.pop()) != s.charAt(i)) {
                return false;

            }
        }

        return stack.isEmpty();
    }
}
