
# Description

You are packing for a vacation on the sea side and you are going to carry only one bag with capacity S (1 <= S <= 2000). You also have N (1<= N <= 2000) items that you might want to take with you to the sea side. Unfortunately you can not fit all of them in the knapsack so you will have to choose. For each item you are given its size and its value. You want to maximize the total value of all the items you are going to bring. What is this maximum total value?

# Basic idea 

There are N items, for each item you can choose have it or not, so the total number of combinations is 2^n. Because there are two variables (value & size) we should take care of, the basic idea of dp is to use a 2D array dp[i][j], where i denoting only using first i elements and j denoting the capacity is less than j. As for state transfer equation, we can think when we meet ith element knowing the results of (i-1)th element, we have two choises: select ith element or not. If we donot select ith element, then dp[i][j] = dp[i-1][j]; otherwise dp[i][j] = dp[i-1][ j-size[i] ]+value[i]. So we can just take the maximum one as the result of dp[i][j]. There are some special cases need to pay attention: if i == 0, dp[i][j] = value[i] if j >= size[i]; ortherwise dp[i][j] = 0. 
This is very important, so other knapsack problems are all based on this one. You should not move forward to others until understank this one fully. 

# Space optimatization

According to state transfer equation dp[i][j] = max(dp[i-1][j], dp[i-1][ j-size[i] ]+value[i] )We can tell when we calculate dp[i][j], we only need dp[i-1][.], so we don't need an extra dimension to record for order of items: dp[i][j] --> dp[j], dp[i-1][j] --> dp[j] (what? you may ask am I kidding you, why dp[i-1][j] and dp[i][j] are equal) Actually they are not equal, at least for some of j. We use loops to update dp[j], considering in the loop of "i-1", dp[j] is dp[i-1][j], in the loop of "i", dp[i][j], so whenever I meet dp[j], before updating it is actually dp[i-1][j], after updating it will be dp[i][j]. Another one we need is dp[i-1][ j-size[i] ], it is the similar reason that we can just use dp[j-size[i] ] to get dp[i-1][ j-size[i] ]. But if loop through j forwardly, dp[j-size[i] ] is dp[i][ j-size[i] ] instead of dp[i-1][ j-size[i] ], we have to ensure dp[j] is calculated before dp[j- size[i] ], so we should loop through j backwardly. 
``` python
Pysudo code:
for i = 1..N
	for j=V..0
		dp[j] = max(dp[j],dp[ j-size[i] ]+value[i])