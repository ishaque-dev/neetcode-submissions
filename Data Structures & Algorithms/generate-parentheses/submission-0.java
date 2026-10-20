class Solution {
    public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), res);
        return res;
    }

     void generate(int maxCount, int openCount, int closeCount, StringBuilder current, List<String> result) {
        if (current.length() == 2 * maxCount) {
            result.add(current.toString());
            return;
        }
        if (openCount < maxCount) {
            current.append("(");
            generate(maxCount, openCount + 1, closeCount, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (closeCount < openCount) {
            current.append(")");
            generate(maxCount, openCount, closeCount + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
