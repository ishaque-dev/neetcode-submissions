class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
           Stack<Integer> stk = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!stk.isEmpty() && temperatures[stk.peek()] < currentTemp) {
                int index = stk.pop();
                result[index] = i - index;
            }
            stk.push(i);
        }
        return result;
    }
}
