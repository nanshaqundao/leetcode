---
name: benchmark
description: Run JMH benchmark tests on a LeetCode problem to measure performance (speed and memory). Use when user says benchmark problem, test performance, or measure speed/memory followed by a number.
allowed-tools: Bash(./gradlew.bat:*), Bash(mkdir:*), Read, Write
argument-hint: [problem-number]
---

# Benchmark Problem

Run JMH benchmark tests to measure performance of a LeetCode solution.

## Instructions

When the user provides a problem number:

1. Normalize the problem number to 4 digits with leading zeros (e.g., "1" → "0001", "206" → "0206")
2. Set the folder path: `p<normalized_number>` (e.g., "p0001", "p0206")
3. Check if benchmark file exists at: `src/jmh/java/leetcode/p<normalized_number>/BenchmarkSolution.java`
4. **If benchmark doesn't exist, CREATE IT:**
   - First, read the Solution.java file to understand the problem structure
   - Identify the main solution method(s) and test cases
   - Create the benchmark directory: `mkdir -p src/jmh/java/leetcode/p<normalized_number>`
   - Generate an appropriate BenchmarkSolution.java file based on the solution
   - Use the template structure shown below, adapting it to the specific problem
5. Run JMH benchmark: `./gradlew.bat jmh -Pjmh.includes=leetcode.p<normalized_number>.BenchmarkSolution`
6. Display the benchmark results showing:
   - Average execution time per operation
   - Throughput (operations per second)
   - Any profiler data if enabled

## Benchmark File Template

When creating a benchmark file, analyze the Solution.java to determine:
- What is the main method to benchmark?
- What test data structures are needed?
- What are representative test cases?

Use this template structure:
```java
package leetcode.p####;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(1)
public class BenchmarkSolution {

    private Solution solution;
    // Add test data fields based on the problem

    @Setup
    public void setup() {
        solution = new Solution();
        // Initialize test data based on test cases in Solution.java
    }

    @Benchmark
    public void benchmarkMethod(Blackhole bh) {
        // Benchmark the solution method with test data
        bh.consume(solution.solutionMethod(testData));
    }
}
```

## Examples

**Example 1: Problem 206 (Reverse Linked List)**
- Read Solution.java, identify `reverseList(ListNode head)` method
- Create test cases with different list sizes (2 nodes, 5 nodes, empty)
- Each benchmark method clones the list and benchmarks reverseList

**Example 2: Problem 141 (Linked List Cycle)**
- Read Solution.java, identify `hasCycle(ListNode head)` method
- Create test cases: list with cycle, list without cycle
- Benchmark both scenarios separately

## Optional: Enable GC Profiling

For memory allocation analysis, uncomment in build.gradle:
```groovy
profilers = ['gc']
```
