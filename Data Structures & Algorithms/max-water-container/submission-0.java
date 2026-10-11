class Solution {
    public int maxArea(int[] heights) {
          int left = 0;
        int max = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int currentArea = Math.min(heights[left], heights[right]) * width;
            max = Math.max(max, currentArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

        }
        return max;
    }
}
