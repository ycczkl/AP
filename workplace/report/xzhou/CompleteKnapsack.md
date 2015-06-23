# Description

Given N kind of items where the ith kind of item has infinite ones and each of them has size c[i] and value w[i] [1 <= i <= N], design an algorithm to maximize the total value of items filled into a knapsack with capacity V. So the sum of sizes in the knapsack shouldn't be bigger than V.


# Basic idea
The biggest difference between this one and knapsack01 is that for each item you have unlimited supplies. So when you meet an item, the choice is not just whether to select it, but how many you should select (including 0). Therefore naturally we can think of adding an additional loop through the number of elements we want to pick. Again let's review the state equation for knapsack01: 
``` python
dp[i][j] = max(dp[i-1][j],dp[i-1][j-cost[i]]+value[i])
``` 
This is actually representing to pick (dp[i-1][j-cost[i]]+value[i]) or not to pick (dp[i-1][j]); right now we want to know how many we should pick, so instead the state equation becomes:
```python
dp[i][j] = max(dp[i-1][j-k*size[i]] + k* value[i]) 
	where (0<=k) && (k*size[i] <= j)
```
k is the amount of the item you want to try as long as the total size is less then the capacity. We can tell that the time complexity is O(V^2 * N) and space is O(VN)

# Optimization
We can do it in O(VN) in a smart way. The physical meaning of dp[i][j] is the maximum only using first i items within j capacity. Similarly dp[i-1][j] is the maximum only using first (i-1) items within j capacity. dp[i][j-size[i]] is the maximum only using first i items within j - size[i] capacity, in other words, we can still add one ith item into the bag. Knowing these physical meaning, we can think this question as another way: We don't care about the amount of each item we should pick, instead when we meet an item, we still have two choice: select it (no matter how many) into the bag or not. If not, it is dp[i-1][j]; if so we can add one item into the bag based on dp[i][j-size[i]]. (Why?) Because dp[i][j-size[i]] is the maximum with less capacity, it may already include k ith items, we don't care what exactly k is, but we know the k is optimal in the context of d[i][j-size[i]], so we can just add one to make it optimal in the context of d[i][j]. Therefore the state transfer equation is 
``` python 
dp[i][j] = max(dp[i-1][j], dp[i][j-size[i]] + value[i])
```

# Space
We can play the same trick with knapsack01 to optimize space, won't talk about it here. You should be able to do it yourself right now. 
