class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int n : prices) {
            if (n < min)
                min = n;
            max = Math.max(max, n-min);
        }
        return max;
    }
}