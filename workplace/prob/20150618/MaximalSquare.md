# Description

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area and indices of its corners from left to right and from top to down.

For example, given the following matrix:

```ruby
1 0 1 0 0
1 0 *1 1* 1
1 1 *1 1* 1
1 0 0 1 0
```
Return 4 and (1 2 1 3 2 2 2 3)

## Input File

1) Line 1: N, i.e. number of test cases

2) Line 2: Number of Rows and Number of Columms for testcase#1

3) Line 3: a binary array formed by scanning the 2D binary matrix from left to right and from top to down

.
<br>
.
<br>

2N) Line 2N: Number of Rows and Number of Columms for testcase#N

2N+1) Line 2N+1: a binary array formed by scanning the 2D binary matrix from left to right and from top to down


## Output File 

1) Line 1: areas of the corners of the maximal square for testcase#1

2) Line 2: indices of the corners of the maximal square for testcase#1

3) Line 3: blanket line

.
<br>
.
<br>

3N-2) Line 3N-2: areas of the corners of the maximal square for testcase#N

3N-1) Line 3N-1: indices of the corners of the maximal square for testcase#N


## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
4 5
<br>
1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
<br>
2 2
<br>
1 1 1 1

### Output
4
<br>
1 2 1 3 2 2 2 3
<br><br>
4
<br>
0 0 0 1 1 0 1 1



