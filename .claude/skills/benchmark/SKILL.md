---
name: benchmark
description: Run JMH benchmark tests on a LeetCode problem to measure performance (speed and memory). Use when user says benchmark problem, test performance, or measure speed/memory followed by a number.
allowed-tools: Bash(./gradlew.bat:*), Read
argument-hint: [problem-number]
---

# Benchmark Problem

Run JMH benchmark tests to measure performance of a LeetCode solution.

## Instructions

When the user provides a problem number:

1. Normalize the problem number to 4 digits with leading zeros (e.g., "1" → "0001", "206" → "0206")
2. Set the folder path: `p<normalized_number>` (e.g., "p0001", "p0206")
3. Check if benchmark file exists at: `src/jmh/java/leetcode/p<normalized_number>/BenchmarkSolution.java`
4. If benchmark doesn't exist, inform the user they need to create it first
5. Run JMH benchmark: `./gradlew.bat jmh -Pjmh.includes=leetcode.p<normalized_number>.BenchmarkSolution`
6. Display the benchmark results showing:
   - Average execution time per operation
   - Throughput (operations per second)
   - Any profiler data if enabled

## Optional: Enable GC Profiling

For memory allocation analysis, the user can enable GC profiling by uncommenting the profilers line in build.gradle:
```groovy
profilers = ['gc']
```

This will show allocation rates and garbage collection statistics.

## Examples

- User provides "206" or says "benchmark problem 206":
  - Normalize to "0206"
  - Check for `src/jmh/java/leetcode/p0206/BenchmarkSolution.java`
  - Run: `./gradlew.bat jmh -Pjmh.includes=leetcode.p0206.BenchmarkSolution`
  - Display results with timing and throughput

- User provides "1":
  - Normalize to "0001"
  - Check for benchmark file
  - If missing, tell user to create `src/jmh/java/leetcode/p0001/BenchmarkSolution.java`

## Benchmark File Structure

Each benchmark should follow this pattern:
```java
package leetcode.p####;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
public class BenchmarkSolution {

    private Solution solution;

    @Setup
    public void setup() {
        solution = new Solution();
    }

    @Benchmark
    public void benchmarkMethod(Blackhole bh) {
        bh.consume(solution.method());
    }
}
```
