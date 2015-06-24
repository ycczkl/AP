# Description

N heap of stones are placed in a circle around the playground. Stone is to have the order to merge into one pile. Provisions can only choose two adjacent stones piled merged into a new bunch of the new pile of stones. Each time, you merge two adjacent piles of stones, the total number stones in these two piles contributes to your score

Design an algorithm to calculate the n heap the stones merged into a bunch of minimum score and maximum score.

## Input File

1) Line 1: heap number N (1 <= N <= 100)

2) Line 2: numbers of stones in each heap, every two numbers separated by a space


## Output File 

1) Line 1: minimum score

2) Line 2 to Line N: scores after each merge and piles of stone after each merge

3) Line N+1: blanket line

4) Line N+2: maximum score

5) Line N+3 to Line 2N+1: piles of stone after each merge

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
4
<br>
4 4 5 9

### Output
43
<br>
8 8 5 9
<br>
21 13 9
<br>
43 43
<br><br>
54
<br>
14 4 4 14
<br>
32 4 18
<br>
54 54



