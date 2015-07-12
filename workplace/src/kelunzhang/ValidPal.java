public class ValidPal {
	//alphanumeric characters: 0-9, a-z, A-Z
    //Corner case: empty string, ",.", String only contains space
    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s == null || s.length() == 0 || s.length() == 1) return true;
        int l = 0;
        int r = s.length()-1;
        
        while (l < r) {
            while (!isValid(s.charAt(l))) {
                l++;
                if (l > r) return true;
            }
            while (!isValid(s.charAt(r))) {
                r--;
                if (r < l) return true;
            }
            char c1 = Character.toLowerCase(s.charAt(l));
            char c2 = Character.toLowerCase(s.charAt(r));
            if (c1 != c2)
                return false;
            l++;
            r--;
        }
        return true;
    }
    private boolean isValid(Character c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}