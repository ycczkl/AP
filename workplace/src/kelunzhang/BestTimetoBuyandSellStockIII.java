class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //Create to arry to store the profit at i day in one transaction.
        int[] profit1 = new int[prices.length];
        int[] profit2 = new int[prices.length];
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
            profit1[i] = max;
        }   
        max = 0;
        int localMax = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0; i--) {
            max = Math.max(max, localMax - prices[i]);
            localMax = Math.max(localMax, prices[i]);
            profit2[i] = max;
        }
        max = 0;
        //Iterate two array, add the max profit from left side to i and i to right side.
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, profit1[i]+profit2[i]);
        }
        return max;
    }
}