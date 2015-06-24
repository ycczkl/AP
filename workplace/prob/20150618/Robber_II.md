# Description

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are ```arranged in a circle.``` That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight ```without alerting the police.```

## Input File

1) Line 1: N, Number of Test Cases

2) Line 2 to Line N+1: each line is a list of numbers (each is the amount of money in each house) seperated by white spaces


## Output File 

1) Line 1: maximal amount of money you can rob for testcase#1

2) Line 2: list of indices (starting from 0) of the robbed houses for testcase#1 (If this list doesn't exist, print -1)

3) Line 3: list of money of the robbed houses for testcase#1 (If this list doesn't exist, print -1)

4) Line 4: blanket line
.
<br>
.
<br>

4N-3) Line 4N-2: maximal amount of money you can rob for testcase#N

4N-2) Line 4N-1: list of indices of the robbed houses for testcase#N

4N-1) Line 4N: list of money of the robbed houses for testcase#N

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
1 2
<br>
1 2 3 4 5 1 2 3 4 5

### Output
0
<br>
-1
<br>
-1
<br>
<br>
16
<br>
2 4 7 9
<br>
3 5 3 5



