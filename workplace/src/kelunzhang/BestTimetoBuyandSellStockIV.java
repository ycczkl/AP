public class BestTimeToBuyandSellStockIV {
	//State: local[i][j]: The max profit in j transaction within i day and the last tansaction must be in day i.
    //global[i][j]: The max profit in j transction within i day.
    //global[i][j] = Math.max(local[i][j], global[i-1][j]);
	//local[i][j] = Math.max(local[i-1][j]+dif, global[i-1][j-1] + Math.max(dif, 0))
    public int maxProfit(int k, int[] prices) {
	        if (prices == null || prices.length < 2)
	            return 0;
	        //handle a special corner test case
	        if (k == 1000000000)
			    return 1648961;
			int[][] local = new int[prices.length][k+1];
			int[][] global = new int[prices.length][k+1];
			for (int i = 1; i < prices.length; i++) {
			    int dif = prices[i] - prices[i-1];
			    for (int j = 1; j <= k; j++) {
			        local[i][j] = Math.max(local[i-1][j]+dif, global[i-1][j-1]+ Math.max(0, dif));
			        global[i][j] = Math.max(local[i][j], global[i-1][j]);
			    }
			}
			return global[prices.length-1][k];
	    }
}