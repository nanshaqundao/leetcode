---
name: run-problem
description: Compile and run a LeetCode problem solution. Use when user says run problem, execute problem, or test problem followed by a number.
allowed-tools: Bash(javac:*), Bash(java:*), Bash(cd:*)
argument-hint: [problem-number]
---

# Run Problem

Compile and run a LeetCode problem solution without Maven.

## Instructions

When the user provides a problem number:

1. Normalize the problem number to 4 digits with leading zeros (e.g., "1" → "0001", "42" → "0042")
2. Set the folder path: `p<normalized_number>` (e.g., "p0001", "p0042")
3. Change to the src/main/java directory
4. Compile: `javac leetcode/p<normalized_number>/Solution.java`
5. If compilation succeeds, run: `java leetcode.p<normalized_number>.Solution`
6. Display the output to the user
7. If compilation fails, show the error messages

Always run both commands from the src/main/java directory using `cd` to ensure proper package resolution.

## Examples

- User provides "1" or says "run problem 1":
  - Normalize to "0001"
  - Compile: `javac leetcode/p0001/Solution.java` from src/main/java
  - Run: `java leetcode.p0001.Solution` from src/main/java

- User provides "42":
  - Normalize to "0042"
  - Compile: `javac leetcode/p0042/Solution.java` from src/main/java
  - Run: `java leetcode.p0042.Solution` from src/main/java
