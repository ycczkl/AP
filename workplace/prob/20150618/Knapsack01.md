# Description

You are packing for a vacation on the sea side and you are going to carry only one bag with capacity S (1 <= S <= 2000). You also have N (1<= N <= 2000) items that you might want to take with you to the sea side. Unfortunately you can not fit all of them in the knapsack so you will have to choose. For each item you are given its size and its value. You want to maximize the total value of all the items you are going to bring. What is this maximum total value?

```Online Judge:``` http://www.spoj.com/problems/KNAPSACK/

## Input File

1) Line 1: Number of test cases

2) Line 2: S and N for testcase#1

3) Line 3: an array of sizes for testcase#1

4) Line 4: an array of values for testcase#1

5) Line 5: blanket line

Repeat the Line 2 to Line 5 for the remaining test cases.

## Output File 

1) Line 1: an array of indices of selected items for testcase#1 (if there's nothing, output 0)

2) Line 2: sum of sizes followed by an array of sizes of selected items for testcase#1 (if there's nothing, output 0)

3) Line 3: maximal values followed by an array of values of selected items for testcase#1 (if there's nothing, output 0)

5) Line 5: blanket line

Repeat the Line 1 to Line 5 for the remaining test cases.

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
1
<br>
4 5
<br>
1 2 3 2 2
<br>
8 4 0 5 3

### Output
0 3
<br>
3 1 2
<br>
13 8 5




