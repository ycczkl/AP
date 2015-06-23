
# Description

Given N items where the ith item has value w[i] and two different kinds of costs a[i] and b[i] [1 <= i <= N], design an algorithm to maximize the total value of items where both kinds of costs are not bigger than V and U respectively.


# Basic idea 

Except there are two different costs rather than one, the question is excactly the same as knapsack01: each item only have one copy, so for each item you can choose have it or not. We can just add an additional dimension in the dp array to track the extra cost: d[i][j][k], where i denoting only using first i elements and j denoting the first kind of capacity(a) is less than j, and k denoting the second kind of capacity(b) is less than k. As for the state transfer equation, for knapsack01 is 
``` python
dp[i][j] = max(dp[i-1][j],dp[i-1][j-cost[i]]+value[i])
``` 
Similarly, for 2D knapsack is
```python
dp[i][j][k] = max(dp[i-1][j][k],dp[i-1][j-a[i]][k-b[i]]+value[i])
``` 
# Space optimatization

Still similar to knapsack01, this algorithm can be also optimized in space, we don't need an extra dimension to record for order of items. The idea is exactly the same as knapsack01, if not understank, please see knapsack01 report. The pysudo code is below:
``` python
for i = 1..N
	for j=V..0
		for k=U..0
			dp[j][k] = max(dp[j][k],dp[j-a[i]][k-b[i]]+value[i])