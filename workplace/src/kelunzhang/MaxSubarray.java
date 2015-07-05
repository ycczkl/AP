public class MaxSubarray {
	/**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        int globalMax = nums.get(0);
        int localMax = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > localMax+nums.get(i)) {
                localMax = nums.get(i);
            } else {
                localMax += nums.get(i);
            }
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }
}