class Solution {
    public int evalRPN(String[] tokens) {
         if (tokens == null || tokens.length == 0) {
            return -1;
        }
        Stack<Integer> stack = new Stack<Integer>();

        for (String str : tokens) {

            if (isOperator(str)) {
                int first = stack.pop();
                int second = stack.pop();
                int result = performOps(second, first, str);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));

            }

        }
        return stack.pop();
    }

        private boolean isOperator(String st) {
        return st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/");
    }

    private int performOps(int first, int second, String operator) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                throw new IllegalArgumentException("Invalid Operator");
        }
    }
}
