class Solution {
    public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
        int right = 1;
        for (int i : piles) {
            right = Math.max(right, i);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

     boolean canFinish(int[] piles, int speed, int maxTime) {
        int hoursRequired = 0;
        for (int i : piles) {
            hoursRequired += Math.ceil((double) i / speed);
        }
        return hoursRequired <= maxTime;
    }
}
