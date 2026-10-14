class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        int[] answer = new int[nums.length - k + 1];
        Deque<Integer> dQ = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dQ.isEmpty() && dQ.peekFirst() < i - k + 1) {
                dQ.pollFirst();
            }
            while (!dQ.isEmpty() && nums[i] > nums[dQ.peekLast()]) {
                dQ.pollLast();
            }
            dQ.offerLast(i);
            if (i >= k-1) {
                answer[i - k + 1] = nums[dQ.peekFirst()];
            }

        }
        return answer;
    }
}
