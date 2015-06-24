
public class MaximalSquare {
	//Use m*n space
	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = (matrix[i][0] == '0' ? 0 : 1);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = (matrix[0][i] == '0' ? 0 : 1);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
            }
        }
        int max = 0;
        for (int[] row : dp) {
            for (int i : row) {
                max = Math.max(max, i);
            }
        }
        return max*max;
    }
	
	//Use 2*m space
	public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] row1 = new int[matrix[0].length];
        int[] row2 = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix[0].length; i++) {
        	row1[i] = matrix[0][i] - '0';
        	max = Math.max(max, row1[1]);
        }
        for (int i = 1; i < matrix.length; i++) {
        	for (int j = 1; j < matrix[0].length; j++) {
        		row2[0] = matrix[i][0] - '0';
        		max = Math.max(row2[0], max);
        		if (matrix[i][j] == '1') {
        			row2[j] = Math.min(row2[j-1], Math.min(row1[j-1], row1[j])); 
        			max = Math.max(row2[j], max);
        		}
        	}
        	for (int k = 0; k < matrix[0].length; k++)
        		row1[k] = row2[k];
        }
        return max*max;
    }
}
