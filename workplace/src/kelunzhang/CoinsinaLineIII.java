public class CoinsinaLineIII {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values.length <= 1) return true;
        //dp[i][j]: The max profit we can get from index i to j
        //sum[i][j]: The total value of comins from index i to j
        //dp[i][j] = Math.max(sum[i][j] - dp[i+1][j], sum[i][j] - dp[i][j-1])
        //Mthod2: dp[i][j] = Math.max(values[i]+max(dp[i+2][j], dp[i+1][j-1]), value[j]+max(dp[i][j-2],dp[i+1][j-1]))
        int len = values.length;
        int[][] sum = new int[len][len];
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                sum[j][i] = values[j] + (i==j ? 0 : sum[j+1][i]);
            }
        }
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j)
                    dp[i][j] = values[i];
                else {
                    dp[i][j] = sum[i][j] - Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1] >= sum[0][len-1]-dp[0][len-1];
    }
}