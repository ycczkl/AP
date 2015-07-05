public class CoinsinaLineII {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values.length < 3) return true;
        int one = values[values.length-1];
        int two = values[values.length-2] + one; 
        int sum = two;
        for (int i = values.length-3; i >= 0; i--) {
            sum += values[i];
            //At position i the max profit will be sum - min(one, two).
            int tmp = sum - Math.min(one, two);
            one = two;
            two = tmp;
        }
        return two > (sum-two);
    }
}