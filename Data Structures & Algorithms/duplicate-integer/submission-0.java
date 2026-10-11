class Solution {
    public boolean hasDuplicate(int[] nums) {
           if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int integer : nums) {
            if (set.contains(integer)) {
                return true;
            }
            set.add(integer);
        }
        return false;
    }
}