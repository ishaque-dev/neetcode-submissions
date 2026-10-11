class Solution {
    public int longestConsecutive(int[] nums) {
      if (nums == null || nums.length == 0) {
            return 0;
        }
           Arrays.sort(nums);
        int longest = 1;
        int currentLongest = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] > 1) {
                currentLongest = 1;
            }
            if (nums[i] - nums[i - 1] == 1) {
                currentLongest++;
            }

            longest = Math.max(currentLongest, longest);

        }
        return longest;
    }
}
