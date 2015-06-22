# Description

Given N items where the ith item has value w[i] and two different kinds of costs a[i] and b[i] [1 <= i <= N], design an algorithm to maximize the total value of items where both kinds of costs are not bigger than V and U respectively.
## Input File

1) Line 1: Number of test cases

2) Line 2: N and V and U

3) Line 3: N integers, each of which is the value of the corresponding item for testcase#1

4) Line 4: N integers, each of which is the first cost of the corresponding item for testcase#1

5) Line 5: N integers, each of which is the second cost of the corresponding item for testcase#1

6) Line 6: blanket line

Repeat the Line 2 to Line 6 for the remaining test cases.

## Output File 

1) Line 1: Maximal values for testcase#1

2) Line 2: Indices of selected items (only one possible sol needed/ if there's nothing, output -1)

3) Line 3: blanket line

Repeat the Line 1 to Line 3 for the remaining test cases.

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
3 5 8
<br>
2 3 4
<br>
2 1 3
<br>
6 4 2
<br><br>
3 7 9
<br>
2 3 4
<br>
2 1 3
<br>
6 4 2

### Output
7
<br>
1 2
<br><br>
7
<br>
1 2




