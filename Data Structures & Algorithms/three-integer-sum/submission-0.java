class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumEval(nums, i, answer);
            }
        }
        return answer;
    }

    private List<List<Integer>> twoSumEval(int[] nums, int i, List<List<Integer>> answer) {
        int start = i + 1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[i] + nums[start] + nums[end];
            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else {
                answer.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            }
        }
        return answer;
    }
}
