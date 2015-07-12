public class GenParnt {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(0, 0, n, new StringBuilder(), res);
        return res;
    }
    private void helper(int i, int j, int n, StringBuilder sb, List<String> res) {
        if (i >= n && j >= n) {
            res.add(sb.toString());
            return;
        }
        if (i < n) {
            sb.append('(');
            helper(i+1, j ,n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if (j < n && j < i) {
            sb.append(')');
            helper(i, j+1, n, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    } 
}