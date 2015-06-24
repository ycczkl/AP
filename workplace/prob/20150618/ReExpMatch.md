# Description

Implement regular expression matching with support for '.' and '*'.

```
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```

## Input File

1) Line 1: N, i.e. Number of test cases
2) Line 2 to Line N+1: each line contains two strings seperated by white space. The first one is the string to be checked. The second is the pattern.

## Output File 

1) Line 1 to Line N: True/False (whether the string is matched with the pattern for each testcase)

## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
ab .*
<br>
aab aa

### Output
True
<br>
False




