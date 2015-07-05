public class MaxSubarrayII {
	/**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
	//Same method with best time to buy and sell stock III
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        int localMax = nums.get(0);
        int globalMax = nums.get(0);
        int[] dp1 = new int[nums.size()];
        int[] dp2 = new int[nums.size()];
        dp1[0] = nums.get(0);
        //dp1[i]: The max subarray sum from 0 to i
        for (int i = 1; i < nums.size(); i++) {
            if (localMax + nums.get(i) < nums.get(i)) {
                localMax = nums.get(i);
            } else {
                localMax += nums.get(i);
            }
            globalMax = Math.max(globalMax, localMax);
            dp1[i] = globalMax;
        }
        dp2[nums.size()-1] = nums.get(nums.size()-1);
        globalMax = localMax = dp2[nums.size()-1];
        //dp2[i]: The max subarray sum from i to nums.size()-1
        for (int i = nums.size()-2; i >= 0; i--) {
            if (localMax + nums.get(i) < nums.get(i)) {
                localMax = nums.get(i);
            } else {
                localMax += nums.get(i);
            }
            globalMax = Math.max(globalMax, localMax);
            dp2[i] = globalMax;
        }
        globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size()-1; i++) {
            globalMax = Math.max(globalMax, dp1[i] + dp2[i+1]);
        }
        return globalMax;
    }
}