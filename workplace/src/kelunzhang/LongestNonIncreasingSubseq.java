class LongestNonIncreasingSubseq{
	public int longestNonIncreasingSubseq(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= dp[len-1]) {
                dp[len++] = nums[i];
                
            }
            else {
                int j = binarySearch(0, len-1, nums[i], dp);
                dp[j] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int l, int r, int v, int[] dp) {
        while (l+1 < r) {
            int mid = (l+r)/2;
            if (dp[mid] == v) {
                return mid;
            } else if (dp[mid] < v) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return dp[l] > v ? l : r;
    }
}