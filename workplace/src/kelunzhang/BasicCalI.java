public class BasicCalI {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        int res = 0;
        int sign = 1;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                num = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                sign = stack.pop();
                res = sign * res + stack.pop();
                num = 0;
                sign = 1;
            }
            i++;
        }
        return res + sign * num;
    }
}