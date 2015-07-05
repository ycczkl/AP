class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1.length() == 0 || word1 == null)
			return word2.length();
		if (word2.length() == 0 || word2 == null)
			return word1.length();
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();
		int[][] dp = new int[w1.length + 1][w2.length + 1];
		for (int i = 1; i <= w1.length; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= w2.length; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= w1.length; i++) {
			for (int j = 1; j <= w2.length; j++) {
				if (w1[i - 1] == w2[j - 1])
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,
							Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
				}
			}
		}
		return dp[w1.length][w2.length];
	}
	
	public int minDistance2(String word1, String word2) {
		if (word1.length() == 0 || word1 == null)
			return word2.length();
		if (word2.length() == 0 || word2 == null)
			return word1.length();
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();
		int[] dp = new int[w2.length + 1];
		
		for (int j = 1; j <= w2.length; j++) {
			dp[j] = j;
		}
		for (int i = 1; i <= w1.length; i++) {
			int[] tmp = new int[w2.length+1];
			tmp[0] = i;
			for (int j = 1; j <= w2.length; j++) {
				if (w1[i - 1] == w2[j - 1])
					tmp[j] = dp[j - 1];
				else {
					tmp[j] = Math.min(dp[j - 1] + 1,
							Math.min(dp[j] + 1, tmp[j - 1] + 1));
				}
			}
			dp = tmp;
		}
		return dp[w2.length];
	}
}