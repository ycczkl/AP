public class PalNum {
	// Consider corner case: Such as negtive number
	// Use two pointer method, one from left, one from right
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		String s = x + "";
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) == s.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}
}