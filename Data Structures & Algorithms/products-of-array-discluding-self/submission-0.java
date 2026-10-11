class Solution {
    public int[] productExceptSelf(int[] nums) {
         int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        int prefix = 1;
        int postFix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= postFix;
            postFix = postFix * nums[i];
        }

        return answer;
    }
}  
