# LeetCode Practice

A Java project for solving LeetCode problems using plain Java (no Maven required).

## Setup

### Prerequisites
- JDK 21 (installed ✓)

### Project Structure
```
leetcode/
├── src/
│   └── main/java/leetcode/
│       ├── p0001/             # Problem 1 folder
│       │   └── Solution.java
│       ├── p0002/             # Problem 2 folder
│       │   └── Solution.java
│       └── ...
└── README.md
```

Each problem has its own folder named `p####` (e.g., `p0001`, `p0042`, `p1234`) containing:
- `Solution.java` - Your solution with test cases in main()

## Usage

### 1. Create a new problem

**Easy way with Claude Skill:**
```bash
/setup-problem 1
```

**Manual way:**
```bash
# For Problem 1
mkdir -p src/main/java/leetcode/p0001
```

Then use this template in `src/main/java/leetcode/p0001/Solution.java`:
```java
package leetcode.p0001;

/**
 * Problem 1: Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Your solution here
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases
    }
}
```

### 2. Run with Java

```bash
# For Problem 1
cd src/main/java
javac leetcode/p0001/Solution.java && java leetcode.p0001.Solution
```

### 3. Use Claude Skill (Easiest!)

```bash
# Just provide the problem number
/run-problem 1

# Or with leading zeros
/run-problem 0001
```

## Claude Skills Available

- `/setup-problem <problem_number>` - Create folder and skeleton code for a new problem
- `/run-problem <problem_number>` - Compile and run a specific problem

## Tips

- Use 4-digit folder names: `p0001`, `p0042`, `p1234`
- All solutions are named `Solution.java` within their problem folder
- Add test cases in the `main` method for quick testing
- Include problem description, difficulty, and link in comments
- Document your approach with time/space complexity

## Example: Problem 1 (Two Sum)

Structure:
```
src/main/java/leetcode/p0001/
└── Solution.java          # Your solution with main()
```

Quick run: `/run-problem 1` or `cd src/main/java && javac leetcode/p0001/Solution.java && java leetcode.p0001.Solution`