class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int columns = matrix.length;
        int rows = matrix[0].length;
        int left = 0;
        int right = rows * columns - 1;
        while (left <= right) {
            int midPoint = left + (right - left) / 2;
            int midValue = matrix[(midPoint / rows)][midPoint % rows];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = midPoint + 1;
            } else {
                right = midPoint - 1;
            }
        }
        return false;
    }
}
