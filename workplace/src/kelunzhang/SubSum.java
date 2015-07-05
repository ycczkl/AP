/*
 * Given an array A of n positive integers (including zero), and another positive integer S, design a DP algorithm that determines if there is a subset of A,
 *  where the sum of all the integers in the subset equals to S (the output is true/false).
 */
public class SubSum {
	//dp[i][j] means if the sum of the subsets from[0, j] is i.
	//dp[i][j] = dp[i][j-1] || dp[i-nums[j]][j-1]
	public static boolean subSum(int[] nums, int v) {
		if (nums == null || nums.length == 0) return true;
		boolean[][] dp = new boolean[v+1][nums.length+1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = true;
		}
		for (int i = 1; i <= v; i++) {
			for (int j = 0; j < nums.length; j++) {
				dp[i][j+1] = dp[i][j];
				if (nums[j] <= i)
					dp[i][j+1] = dp[i][j+1] || dp[i-nums[j]][j];
			}
		}
		return dp[v][nums.length];
	}
	
	public static void main(String[] args) {
		int[] a = {3, 34, 4, 12, 5, 2};
		System.out.println(subSum(a, 9));
	}
}	
