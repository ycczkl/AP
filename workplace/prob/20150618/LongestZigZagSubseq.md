# Description

Given an array A of integers, provide a DP algorithm that determines the length of the longest subsequence of A with the following property: The numbers in the subsequence should strictly increase and decrease alternately. For example, 1,7,4,9,2,5 has the property but 1,4,7,2,5 and 1,7,4,5,5 do not. Note that the integers in a subsequence may not be consecutive in the original array but they have to be in the same order.
## Input File

1) Line 1: N, i.e. number of test cases

2) Line 2 to Line N+1: each line is an array of integers

## Output File 

1) Line 1: length of a longest zig-zag subsequence for test#1

2) Line 2: indices (starting from 0) of integers of the subsequence for testcase#1 

3) Line 3: the subsequence for testcase#1

4) Line 4: blanket line

.
<br>
.
<br>

4N-3) Line 4N-3: length of a longest zig-zag subsequence for test#N

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
1 3 2 6 6 5

### Output
2
<br>
0 1
<br>
1 2
<br><br>
5
<br>
0 1 2 3 5
<br>
1 3 2 6 5



