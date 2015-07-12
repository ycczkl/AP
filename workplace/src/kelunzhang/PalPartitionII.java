public class PalPartitionII {
	public int minCut(String s) {
        //dp[i]: The min cut from index 0 to i
        //dp[i] = min(dp[k]+1) (k from 0 to i)
        //TimeO(n^2), space:O(n^2)
        if (s == null || s.length() == 0) return 0;
        boolean[][] dict = getDict(s);
        int[] dp = new int[s.length()+1];
        dp[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (dict[j][i]) {
                    //compute local min cut
                    min = Math.min(min, dp[j]+1);
                }
            }
            dp[i+1] = min;
        }
        return dp[s.length()];
    }
    //get dict
    private boolean[][] getDict(String s) {
        boolean[][] dict = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if ((j-i < 2 || dict[i+1][j-1]) && s.charAt(i) == s.charAt(j)) {
                    dict[i][j] = true;
                }
            }
        }
        return dict;
    }
}