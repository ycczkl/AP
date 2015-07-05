public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0 || !wordBreakTest(s, wordDict))
            return res;
        helper(0, s, new LinkedList<String>(), wordDict, res);
        return res;
    }
    private void helper(int start, String s, LinkedList<String> list, Set<String> dict, List<String> res) {
        if (start > s.length()-1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size()-1)
                    sb.append(' ');
            }
            res.add(sb.toString());
        }
        StringBuilder str = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (dict.contains(str.toString())) {
                list.add(str.toString());
                helper(i+1, s, list, dict, res);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean wordBreakTest(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return true;
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i < s.length(); i++) {
		    StringBuilder sb = new StringBuilder(s.substring(0, i+1));
			for (int j = 0; j <= i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i + 1))) {
					dp[i + 1] = true;
					break;
				}
				sb.deleteCharAt(0);
			}
		}
		return dp[s.length()];
	}
}