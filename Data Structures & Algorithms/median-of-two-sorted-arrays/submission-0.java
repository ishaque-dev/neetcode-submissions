class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int smallArrayLength = nums1.length;
        int largeArrayLength = nums2.length;
        int left = 0;
        int right = smallArrayLength;
        while (left <= right) {
            int leftPartSize = left + (right - left) / 2;
            int rightPartSize = (smallArrayLength + largeArrayLength + 1) / 2 - leftPartSize;
            int elementFromSmallArrayForLeft = leftPartSize == 0 ? Integer.MIN_VALUE
                    : nums1[leftPartSize - 1];
            int elementFromSmallArrayForRight = leftPartSize == smallArrayLength ? Integer.MAX_VALUE
                    : nums1[leftPartSize];
            int elementFromLargeArrayForLeft = rightPartSize == 0 ? Integer.MIN_VALUE
                    : nums2[rightPartSize - 1];
            int elementFromLargeArrayForRight = rightPartSize == largeArrayLength ? Integer.MAX_VALUE
                    : nums2[rightPartSize];
            if (elementFromSmallArrayForLeft <= elementFromLargeArrayForRight
                    && elementFromLargeArrayForLeft <= elementFromSmallArrayForRight) {

                if ((smallArrayLength + largeArrayLength) % 2 == 0) {
                    return (Math.max(elementFromSmallArrayForLeft, elementFromLargeArrayForLeft)
                            + Math.min(elementFromSmallArrayForRight, elementFromLargeArrayForRight)) / 2.0;
                } else {
                    return Math.max(elementFromSmallArrayForLeft, elementFromLargeArrayForLeft);
                }

            } else if (elementFromSmallArrayForLeft > elementFromLargeArrayForRight) {
                right = leftPartSize - 1;
            } else {
                left = leftPartSize + 1;
            }
        }

        return 0.0;
    }
}
