class Robber_II {
	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		return Math.max(houseRob(nums, 0, nums.length - 2),
				houseRob(nums, 1, nums.length - 1));
	}

	// dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1])
	private int houseRob(int[] nums, int l, int r) {
		if (r - l < 0)
			return 0;
		if (r - l <= 1)
			return Math.max(nums[l], nums[r]);
		int[] dp = new int[r - l + 1];
		dp[0] = nums[l];
		dp[1] = Math.max(nums[l], nums[l + 1]);
		for (int i = l + 2; i <= r; i++) {
			dp[i - l] = Math.max(nums[i] + dp[i - l - 2], dp[i - l - 1]);
		}
		return dp[r - l];
	}
}