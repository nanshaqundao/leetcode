---
name: setup-problem
description: Create a new LeetCode problem folder with skeleton Solution.java code. Use when user says setup problem, create problem, or initialize problem followed by a number.
allowed-tools: Bash(mkdir:*), Write
argument-hint: [problem-number]
---

# Setup Problem

Create a new LeetCode problem folder with skeleton code.

## Instructions

When the user provides a problem number:

1. Normalize the problem number to 4 digits with leading zeros (e.g., "1" → "0001", "42" → "0042")
2. Set the folder path: `p<normalized_number>` (e.g., "p0001", "p0042")
3. Create the directory: `mkdir -p src/main/java/leetcode/p<normalized_number>`
4. Create a skeleton `Solution.java` file in that directory with this template:

```java
package leetcode.p<normalized_number>;

/**
 * Problem <number>: [Problem Name]
 * Difficulty: [Easy/Medium/Hard]
 * Link: https://leetcode.com/problems/[problem-name]/
 *
 * Description:
 * [Problem description here]
 */
public class Solution {

    // TODO: Add your solution method here
    public int solutionMethod() {
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        System.out.println("Test 1: " + solution.solutionMethod());

        // TODO: Add more test cases
    }
}
```

5. Inform the user that the problem setup is complete and show:
   - The file path created
   - Instructions to edit the file and fill in problem details
   - How to run it with `/run-problem <number>`

## Examples

- User provides "1" or says "setup problem 1":
  - Normalize to "0001"
  - Create folder: `src/main/java/leetcode/p0001`
  - Create file: `src/main/java/leetcode/p0001/Solution.java`
  - Use `package leetcode.p0001;` in the file

- User provides "42":
  - Normalize to "0042"
  - Create folder: `src/main/java/leetcode/p0042`
  - Create file: `src/main/java/leetcode/p0042/Solution.java`
