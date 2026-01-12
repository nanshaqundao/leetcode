package leetcode.p0142;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(1)
public class BenchmarkSolution {

    private Solution solution;
    private Solution.ListNode smallListCycle;
    private Solution.ListNode smallListNoCycle;
    private Solution.ListNode largeListCycle;
    private Solution.ListNode largeListNoCycle;
    private Solution.ListNode veryLargeListCycle;

    @Setup
    public void setup() {
        solution = new Solution();

        // Small: 4 nodes with cycle at position 1
        Solution.ListNode s1 = new Solution.ListNode(3);
        Solution.ListNode s2 = new Solution.ListNode(2);
        Solution.ListNode s3 = new Solution.ListNode(0);
        Solution.ListNode s4 = new Solution.ListNode(-4);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s2; // Cycle at position 1
        smallListCycle = s1;

        // Small: 5 nodes no cycle
        smallListNoCycle = createList(5, false, -1);

        // Large: 1000 nodes with cycle at middle
        largeListCycle = createList(1000, true, 500);

        // Large: 1000 nodes no cycle
        largeListNoCycle = createList(1000, false, -1);

        // Very Large: 10000 nodes with cycle at middle
        veryLargeListCycle = createList(10000, true, 5000);
    }

    private Solution.ListNode createList(int size, boolean hasCycle, int cyclePos) {
        if (size == 0) return null;

        Solution.ListNode head = new Solution.ListNode(0);
        Solution.ListNode current = head;
        Solution.ListNode cycleStart = null;

        for (int i = 1; i < size; i++) {
            current.next = new Solution.ListNode(i);
            current = current.next;

            // Mark cycle start position
            if (hasCycle && i == cyclePos) {
                cycleStart = current;
            }
        }

        // Create cycle if needed
        if (hasCycle && cycleStart != null) {
            current.next = cycleStart;
        }

        return head;
    }

    @Benchmark
    public void benchmarkSmall_WithCycle(Blackhole bh) {
        bh.consume(solution.detectCycle(smallListCycle));
    }

    @Benchmark
    public void benchmarkSmall_NoCycle(Blackhole bh) {
        bh.consume(solution.detectCycle(smallListNoCycle));
    }

    @Benchmark
    public void benchmarkLarge_WithCycle(Blackhole bh) {
        bh.consume(solution.detectCycle(largeListCycle));
    }

    @Benchmark
    public void benchmarkLarge_NoCycle(Blackhole bh) {
        bh.consume(solution.detectCycle(largeListNoCycle));
    }

    @Benchmark
    public void benchmarkVeryLarge_WithCycle(Blackhole bh) {
        bh.consume(solution.detectCycle(veryLargeListCycle));
    }
}
