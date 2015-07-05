public class MaxSubarrayIII {
	/**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        //The idea is the same with best time to buy and sell stock IV
        //local[i][j] = Math.max(local[i-1][j]+nums.get(i), global[i-1][j-1]+nums.get(i))
        //global[i][j] = Math.max(local[i][j], global[i-1][j])
        if (nums == null || nums.size() == 0 || k > nums.size()) return 0;
        int len = nums.size();
        int[][] local = new int[len][k+1];
        int[][] global = new int[len][k+1];
        local[0][1] = nums.get(0);
        global[0][1] = nums.get(0);  
        //unreachable value
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                 if (i+1 < j) {
                	 local[i][j] = -10000;
                	 global[i][j] = -10000;
                 }
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= Math.min(i+1, k); j++) {
                local[i][j] = Math.max(local[i-1][j]+nums.get(i), global[i-1][j-1]+nums.get(i));
                global[i][j] = Math.max(local[i][j], global[i-1][j]);               
            }
        }
        return global[len-1][k];
    }
}