public class ShortestPal {
	public String shortestPalindrome(String s) {
		// Find the longest palindrome from 0 to k. Reverse the k+1 to n of the string and append to the head.
		if (s == null || s.length() == 0)
			return s;
		int maxIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			int l = i / 2;
			int r = i % 2 == 0 ? i / 2 : i / 2 + 1;
			int k = longestPalindrome(l, r, s);
			maxIndex = Math.max(maxIndex, k);
		}
		StringBuilder sb = new StringBuilder(s.substring(maxIndex + 1,
				s.length()));
		sb.reverse();
		return sb.toString() + s;
	}
	//Return the right index if the substring from 0 to k is palindrome.
	private int longestPalindrome(int l, int r, String s) {
		while (l >= 0) {
			if (s.charAt(l) == s.charAt(r)) {
				l--;
				r++;
			} else {
				return -1;
			}
		}
		return r - 1;
	}
}