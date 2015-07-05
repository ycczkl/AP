
public class TwoDimKnapsack01 {
	//dp[i][j][k] = dp[i-1][j][k] || dp[i-1][j-cost1[i]][k-cost2[i]] + value[i]
	public static int TwoDimKnapsack01(int[] value, int[] cost1, int[] cost2, int u, int v) {
		if (value.length != cost1.length || cost1.length != cost2.length || u < 0 || v < 0) return 0;
		int[][][] dp = new int[value.length+1][u+1][v+1];
		
		for (int i = 0; i < value.length; i++) {
			for (int j = 1; j <= u; j++) {
				for (int k = 1; k <= v; k++) {
					if (cost1[i] > j || cost2[i] > k)
						dp[i+1][j][k] = dp[i][j][k];
					else {
						dp[i+1][j][k] = Math.max(dp[i][j][k], dp[i][j-cost1[i]][k-cost2[i]] + value[i]);
					}
				}
			}
		}
		return dp[value.length][u][v];
	}
	
	public static void main(String[] args) {
		int u = 5;
		int v = 8;
		int[] b = {2,3,4};
		int[] c = {2,1,3};
		int[] d = {6,4,2};
		System.out.println(TwoDimKnapsack01(b,c,d,u,v));
	}
}
