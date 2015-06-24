# Description

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and ```it will automatically contact the police if two adjacent houses were broken into on the same night.```

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight ```without alerting the police.```

## Input File

1) Line 1: N, Number of Test Cases

2) Line 2 to Line N+1: each line is a list of numbers (each is the amount of money in each house) seperated by white spaces


## Output File 

1) Line 1: maximal amount of money you can rob for testcase#1

2) Line 2: list of indices (starting from 0) of the robbed houses for testcase#1

3) Line 3: list of money of the robbed houses for testcase#1

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
2
<br>
1
<br>
2
<br>
<br>
17
<br>
0 2 4 7 9
<br>
1 3 5 3 5



