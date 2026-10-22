class Solution {
    public int largestRectangleArea(int[] heights) {
          Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int max = 0;
        for (int index = 0; index <= n; index++) {
            int currentHeight = (index == n) ? 0 : heights[index];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                max = Integer.max(max, width * height);
            }

            stack.push(index);
        }
        return max;
    }
}
