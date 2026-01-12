package leetcode.p0141;

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
    private Solution.ListNode veryLargeListNoCycle;

    @Setup
    public void setup() {
        solution = new Solution();

        // Small: 4 nodes with cycle
        Solution.ListNode s1 = new Solution.ListNode(1);
        Solution.ListNode s2 = new Solution.ListNode(2);
        Solution.ListNode s3 = new Solution.ListNode(3);
        Solution.ListNode s4 = new Solution.ListNode(4);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s2; // Cycle
        smallListCycle = s1;

        // Small: 5 nodes no cycle
        smallListNoCycle = createList(5, false);

        // Large: 1000 nodes with cycle at end
        largeListCycle = createList(1000, true);

        // Large: 1000 nodes no cycle
        largeListNoCycle = createList(1000, false);

        // Very Large: 10000 nodes no cycle (worst case for HashSet)
        veryLargeListNoCycle = createList(10000, false);
    }

    private Solution.ListNode createList(int size, boolean hasCycle) {
        if (size == 0) return null;

        Solution.ListNode head = new Solution.ListNode(0);
        Solution.ListNode current = head;
        Solution.ListNode cycleStart = null;

        for (int i = 1; i < size; i++) {
            current.next = new Solution.ListNode(i);
            current = current.next;

            // Mark middle node for cycle
            if (hasCycle && i == size / 2) {
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
        bh.consume(solution.hasCycle(smallListCycle));
    }

    @Benchmark
    public void benchmarkSmall_NoCycle(Blackhole bh) {
        bh.consume(solution.hasCycle(smallListNoCycle));
    }

    @Benchmark
    public void benchmarkLarge_WithCycle(Blackhole bh) {
        bh.consume(solution.hasCycle(largeListCycle));
    }

    @Benchmark
    public void benchmarkLarge_NoCycle(Blackhole bh) {
        bh.consume(solution.hasCycle(largeListNoCycle));
    }

    @Benchmark
    public void benchmarkVeryLarge_NoCycle(Blackhole bh) {
        bh.consume(solution.hasCycle(veryLargeListNoCycle));
    }
}
