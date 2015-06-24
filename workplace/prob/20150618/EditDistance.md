# Description

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2 and output the change of word1 in each step. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character

b) Delete a character

c) Replace a character

## Input File

1) Line 1: Nnumber of test cases

2) Line 2 to Line N+1: each line is two words seperated by space

## Output File 

1) Line 1:  minimum number of steps for testcase#1, N1

2) Line 2 to Line N1: the change of word1 of testcase#1 after each step until word1 is converted to word2

3) Line N1 + 1: blanket line

Repeat the lines above for next test case until all testcases are done.

```Note:``` If there's no step, output 0

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
abcd acdb
<br>
aa aa


### Output
2
<br>
acd
<br>
acdb
<br><br>
0
<br>
0

