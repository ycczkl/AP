public class LongestPalSubstr {
	//挡板法
	//Time: O(n^2), Space: O(1)
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return s;
		String globalMax = "";
		for (int i = 0; i < s.length()*2 -1; i++) {
			int l = i/2;
			int r = i % 2 == 0 ? i/2 : i/2 + 1;
			int len = 0;
			while (l >= 0 && r < s.length()) {
				if (s.charAt(l) != s.charAt(r)) {
					break;
				}
				len = r- l + 1;
				if (len > globalMax.length())
					globalMax = s.substring(l, r+1);
				l--;
				r++;
			}
		}
		return globalMax;
	}
	
	//Time: O(n^2) Space: O(n^2)
	//This is also the method to get palindrome dictionary.
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == c && (j-i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        res = s.substring(i,j+1);
                    }
                } 
            }
        }
        return res;
    }
}