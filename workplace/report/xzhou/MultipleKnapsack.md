# Description

Given N kind of items where the ith kind of item has n[i] items at most and each of them has size c[i] and value w[i] [1 <= i <= N], design an algorithm to maximize the total value of items filled into a knapsack with capacity V. So the sum of sizes in the knapsack shouldn't be bigger than V.



# Basic idea

The basic idea is totally the same as completeknapsack. We can write the state transfer equation directly based on that one:
``` python 
dp[i][j] = max(dp[i-1][j-k*size[i]] + k* value[i]) 
	where (0<=k) && (k*size[i] <= j && k <= n[i])
```
we can notice the only difference is we add another contidion k <= n[i] which ensure the number we add is less than or equal to the supply amount. The time complexity is O(NVK)

# Optimization
Firstly, we can transform this problem into the basic knapsack01: For each item with n[i] copies, we can treat them as n[i] items with the same cost and value. Then every item will only have one copy, thus becoming knapsack01. But actually this does not optimize the problem at all, the ime complexity is still O(NVK). Some smart people come up with a clever transformation: log division. Since every int number can be represented as a binary, inspired by this we can divide an item with n[i] copies into several items, each item have one coeffienct, the cost and value of new items is the original one times the coefficient. The coefficient is the power of 2 except the last one (residual): 1,2,4 ... 2^(k-1), n[i]-2^k +1, where n[i]-2^k+1 > 0. For example n[i] = 13, The coefficients are 1,2,4,6. (k = 3). We can see that the sum of the combination of these numbers can represent any number between 1 and n[i]. After this division, the problem is the same as knapsack01. 
