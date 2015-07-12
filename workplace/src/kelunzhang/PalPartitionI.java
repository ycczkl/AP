public class PalPartition {
	//Use the DP method in longest palindromic substring to get palindrom dp array 
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>(); 
        if (s == null || s.length() == 0) return res;
        boolean[][] dict = getDict(s);
        helper(s, 0, new ArrayList<String>(), dict,res);
        return res;
    }
    private void helper(String s, int pos, ArrayList<String> list, boolean[][] dict,List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (dict[pos][i]) {
                list.add(s.substring(pos, i+1));
                helper(s, i+1, list, dict, res);
                list.remove(list.size()-1);
            }
        }
    }
    
    //Get the dictionary
    private boolean[][] getDict(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if ((j-i < 2  || dp[i+1][j-1]) && s.charAt(j) == s.charAt(i))
                    dp[i][j] = true;
            }
        }
        return dp;
    }
}