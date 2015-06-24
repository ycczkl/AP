# Description

Given an array A of n numbers, design a DP algorithm that determines the length of the longest non-decreasing sub-sequence. Note that the integers in a sub-sequence may not be consecutive in the original array but they have to be in the same order. 

```Note:``` It's a variant of [Longest Increasing Subsequence](http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/)
## Input File

1) Line 1: N, i.e. number of test cases

2) Line 2 to Line N+1: each line is an array of integers

## Output File 

1) Line 1: length of a longest non-increasing subsequence for test#1

2) Line 2: indices (starting from 0) of integers of the subsequence for testcase#1 

3) Line 3: the subsequence for testcase#1

4) Line 4: blanket line

.
<br>
.
<br>

4N-3) Line 4N-3: length of a longest non-increasing subsequence for test#N

4N-2) Line 4N-2: indices (starting from 0) of integers of the subsequence for testcase#N

4N-1) Line 4N-1: the subsequence for testcase#N

<br>

```Note:``` Since maybe multiple such subsequences exists, you only need to output one.

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
1 2 3 4 5 6
<br>
2 3 1 5 6 6

### Output
6
<br>
0 1 2 3 4 5
<br>
1 2 3 4 5 6
<br><br>
5
<br>
0 1 3 4 5
<br>
2 3 5 6 6



