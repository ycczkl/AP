# Description

Given an array A of n positive integers (including zero), and another positive integer S, design a DP algorithm that determines if there is a subset of A, where the sum of all the integers in the subset equals to S (the output is true/false).

## Input File

1) Line 1: Number of Test Cases

2) Line 2 to Line N+1: each line is S followed by a array of positive integers

## Output File 

For each test case, output True/False. If the result is true, then print two lines where the first line is the indices of integers summing up as S, and the second line is thoses integers.

Between two test cases are a blanket line.

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
1 2 3
<br>
3 1 2 5 6

### Output
False
<br>
<br>
True
<br>
0 1
<br>
1 2




