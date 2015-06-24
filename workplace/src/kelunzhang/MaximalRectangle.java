import java.util.Stack;


public class maximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        //if matrix[i][j] == '1', dp[j] = dp[j]+1; else dp[j] = 0;
        int[] dp = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[j] = dp[j] + 1;
                } else {
                    dp[j] = 0;
                }
            }
            int localMax = getMax(dp);
            max = Math.max(localMax, max);
        }
        return max;
    }
    private int getMax(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curHeight = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && curHeight < height[stack.peek()]) {
                int index = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                int h = height[index];
                max = Math.max(max, w*h);
            }
            stack.push(i);
        }
        return max;
    }
}
